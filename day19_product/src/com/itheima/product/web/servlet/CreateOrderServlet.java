package com.itheima.product.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.itheima.product.domain.Order;
import com.itheima.product.domain.OrderItem;
import com.itheima.product.domain.Product;
import com.itheima.product.domain.User;
import com.itheima.product.service.OrderService;

public class CreateOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//封装订单数据
		Order order = new Order();
		try {
			BeanUtils.populate(order, request.getParameterMap());
			
			//给一个订单编号
			order.setId(UUID.randomUUID().toString());
			//把session对象中的用户信息保存到order对象中
			order.setUser((User) request.getSession().getAttribute("user"));
			
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		//循环从购物车中把商品信息取出来，存放到orderItem对象中
		Map<Product,String> cart = (Map<Product, String>) request.getSession().getAttribute("cart");
		
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		for (Product p : cart.keySet()) {
			OrderItem oi = new OrderItem();//循环一次商品创建一条表单项，即每个订单中每件商品的信息
			oi.setOrder(order);
			oi.setP(p);
			oi.setBuynum(Integer.parseInt(cart.get(p)));
			
			//把订单项添加到订单中
			orderItems.add(oi);
		}
		
		//把orderItems存放到到order中
		order.setOrderItems(orderItems);
		
		//调用业务逻辑 完成订单
		OrderService os = new OrderService();
		os.addOrder(order);
		
		//分发转向
		request.getRequestDispatcher("/pay.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
