package com.itheima.service.impl;

import com.itheima.dao.IUserDao;
import com.itheima.dao.impl.IUserDaoImpl;
import com.itheima.domian.User;
import com.itheima.service.IUserService;

public class UserServiceImpl implements IUserService{

	private IUserDao dao = new IUserDaoImpl();
	
	@Override
	public User findUserByUsername(String username) {
		return dao.selectUserByUsername(username);
	}

	@Override
	public int register(User user) {
		return dao.addUser(user);
	}

}
