package com.itheima.web.action;

import com.itheima.web.domain.Customer;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ActionContextDemo4 extends ActionSupport implements ModelDriven<Customer>{

	private Customer customer = new Customer(); 
	
	@Override
	public Customer getModel() {
		return customer;
	}

	public String saveCustomer(){
		System.out.println(customer);
		return null;
	}
	
}
