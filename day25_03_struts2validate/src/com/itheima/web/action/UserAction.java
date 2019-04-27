package com.itheima.web.action;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.validation.SkipValidation;

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
	
	/**
	 * 编码式验证
	 * 要求：
	 * 		1.动作类必须继承ActionSupport
	 * 		2.重写validate方法
	 * 
	 * 注意：重写了validate方法，它会对动作类中的所有动作进行验证
	 * 解决验证所有问题动作方法的问题：
	 * 		1.第一种方式：使用@SkipValidation注解，跳过验证
	 * 		2.第二种方式：定义验证方法的名称(哪个方法需要验证，哪个方法改名)
	 * 					 命名方式：validate + 动作名称(动作名称首字母要大写)  eg:validateRegister()
	 * 
	 */
	/*public void validate(){
		if(StringUtils.isBlank(user.getUsername())){
			//出现错误信息，直接存入。调用父类的addFieldError方法
			//第一个参数是表单name的属性值；第二个参数是错误提示
			addFieldError("username", "用户名不能为空！");
		}
	}
	*/
//	@SkipValidation
	public String findAll(){
		return SUCCESS;
	}
	
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
