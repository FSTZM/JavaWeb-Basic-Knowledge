package com.itheima.product.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.product.domain.Order;
import com.itheima.product.domain.OrderItem;
import com.itheima.product.domain.Product;
import com.itheima.product.domain.User;
import com.itheima.product.util.C3P0Utils;
import com.itheima.product.util.ManagerThreadLocal;

public class OrderDao {

	public void addOrder(Order order) throws SQLException {
		QueryRunner qr = new QueryRunner();
		qr.update(ManagerThreadLocal.getConnection(), "insert into orders values(?,?,?,?,?,?,?,?)", order.getId(),
				order.getMoney(), order.getReceiverAddress(), order.getReceiverName(), order.getReceiverPhone(),
				order.getPaystate(), order.getOrdertime(), order.getUser().getId());
	}

	public List<Order> findOrders(int id) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		return qr.query("select * from orders where user_id=?", new BeanListHandler<Order>(Order.class), id);
	}

	public Order findorderByOrderId(String orderid) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

		Order order = qr.query("select * from orders where id=?", new BeanHandler<Order>(Order.class), orderid);

		List<OrderItem> orderItems = qr.query("select * from orderitem o,products p where p.id=o.product_id and order_id=?",
				new ResultSetHandler<List<OrderItem>>() {

					@Override
					public List<OrderItem> handle(ResultSet rs) throws SQLException {
						List<OrderItem> orderItems = new ArrayList<OrderItem>();
						while(rs.next()){
							
							OrderItem oi = new OrderItem();
							oi.setBuynum(rs.getInt("buynum"));
							
							Product p = new Product();
							p.setName(rs.getString("name"));
							p.setPrice(rs.getDouble("price"));
							
							oi.setP(p);
							
							orderItems.add(oi);			
						}
						
						return orderItems;
					}
				}, orderid);
		order.setOrderItems(orderItems);
		return order;
	}

}
