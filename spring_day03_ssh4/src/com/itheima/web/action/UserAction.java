package com.itheima.web.action;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	private User user = new User();
	
	@Override
	public User getModel() {
		return user;
	}
	
	private UserService userService;
	//有了set方法，spring xml文件才能配置
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String register(){
		userService.register(user);
		return "success";
	}

}
