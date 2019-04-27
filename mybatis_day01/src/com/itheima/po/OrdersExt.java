package com.itheima.po;

public class OrdersExt extends Orders {
	
	//oeder中没有用户姓名与性别，因此要扩展order中的信息
	
	private String username;
	private String sex;
	
	private User user;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "OrdersExt [username=" + username + ", sex=" + sex + ", user=" + user + "]";
	}
	
}
