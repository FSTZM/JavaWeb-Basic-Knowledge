package com.itheima.mapper;

import java.util.List;

import com.itheima.po.OrdersExt;
import com.itheima.po.User;

public interface OrderMapper {
	
	public List<OrdersExt> findOrdersAndUser();
	
	public List<OrdersExt> findOrdersAndUserRstMap();
	
	public List<OrdersExt> findOrderAndDetail();
	
	public List<User> findUserAndItemsRstMap();

}
