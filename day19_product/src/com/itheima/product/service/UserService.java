package com.itheima.product.service;

import java.sql.SQLException;

import com.itheima.product.dao.UserDao;
import com.itheima.product.domain.User;
import com.itheima.product.exception.UserException;
import com.itheima.product.util.SendJMail;

public class UserService {

	UserDao ud = new UserDao();
	
	//用户注册
	public void register(User user) throws UserException {
		try {
			ud.addUser(user);
			
			String emailMsg = "注册成功，请<a href='http://localhost:8087/day19_product/ActiveUserServlet?activeCode="+user.getActiveCode()+"'>激活</a>后登录";
			SendJMail.sendMail(user.getEmail(), emailMsg);
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("激活失败！");
		}
	}

	//用户激活
	public void activeUser(String activeCode) throws UserException {
		try {
			User user = ud.findUserByActiveCode(activeCode);
			
			if(user!=null){
				ud.activeUser(activeCode);
				return;
			}
			
			throw new UserException("激活失败！");
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("激活失败！");
		}
	}

	public User login(String username, String password) throws UserException {
		User user = null;
		try {
			user = ud.findUserByUserNameAndPassword(username,password);
			
			if(user==null){
				throw new UserException("用户名或密码错误！");
			}
			
			if(user.getState()==0){
				throw new UserException("用户未激活！");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	public User findUserById(String id) throws UserException {
		User user = null;
		try {
			user = ud.finUserById(id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("查找用户失败！");
		}
		return user;
	}

	public void modifyUser(User user) throws UserException {
		try {
			ud.modifyUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("修改用户信息失败！");
		}
	}

}
