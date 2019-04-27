package com.itheima.dao;

public interface AccountDao {
	/**
	 * 收款
	 * @param username
	 * @param money
	 */
	public void in(String inner,int money);
	
	/**
	 * 付款
	 * @param username
	 * @param money
	 */
	public void out(String outer,int money);

}
