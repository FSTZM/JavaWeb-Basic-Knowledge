package com.itheima.service;

public interface AccountService {
	/**
	 * 转账服务
	 * @param outer
	 * @param inner
	 * @param money
	 */
	public void transfer(String outer,String inner,int money);

}
