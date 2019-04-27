package com.itheima.product.service;

import java.sql.SQLException;
import java.util.List;

import com.itheima.product.dao.OrderDao;
import com.itheima.product.dao.OrderItemDao;
import com.itheima.product.dao.ProductDao;
import com.itheima.product.domain.Order;
import com.itheima.product.util.ManagerThreadLocal;

public class OrderService {

	public void addOrder(Order order) {

		OrderDao orderDao = new OrderDao();
		OrderItemDao orderItemDao = new OrderItemDao();
		ProductDao productDao = new ProductDao();

		// 开启事务
		ManagerThreadLocal.startTransacation();
		try {
			orderDao.addOrder(order);
			orderItemDao.addOrderItem(order);
			productDao.updateProductNum(order);
		} catch (SQLException e) {
			e.printStackTrace();
			//出现错误数据回滚
			ManagerThreadLocal.rollback();
		}

		// 提交事务
		ManagerThreadLocal.commit();

	}

	/**
	 * 根据用户ID查找订单
	 * @param id
	 * @return
	 */
	public List<Order> findOrdersByUserId(int id) {
		OrderDao orderDao = new OrderDao();
		try {
			return orderDao.findOrders(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Order findOrdersByOrderId(String orderid) {
		OrderDao orderDao = new OrderDao();
		try {
			return orderDao.findorderByOrderId(orderid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
