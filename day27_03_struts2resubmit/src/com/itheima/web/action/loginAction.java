package com.itheima.web.action;

import com.opensymphony.xwork2.ActionSupport;

public class loginAction extends ActionSupport {
	
	private String username;
	
	public String login(){
		
		System.out.println(username);
		return SUCCESS;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
}
