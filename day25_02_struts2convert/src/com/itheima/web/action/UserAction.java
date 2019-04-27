package com.itheima.web.action;

import com.itheima.domian.User;
import com.itheima.service.IUserService;
import com.itheima.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	//定义一个用户的数据模型。注意：由于使用了模型驱动，必须自己实例化对象
	private User user = new User();
	
	//实现接口中的抽象方法getModel()
	@Override
	public User getModel() {
		return user;
	}

	private IUserService us = new UserServiceImpl();
	public String register(){
		
		//1.根据用户名获取数据库的用户
		User dbuser = us.findUserByUsername(user.getUsername());
		//2.判断对象是否存在
			//2.1如果存在，返回exists视图
		if(dbuser!=null){
			return "exists";
		}
		//3.不存在，则保存对象信息
		int res = us.register(user);
		//4.如果执行结果大于0
		if(res>0){
			return SUCCESS;
		}
		//5.如果不大于0，则返回null
		return null;
	}
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
