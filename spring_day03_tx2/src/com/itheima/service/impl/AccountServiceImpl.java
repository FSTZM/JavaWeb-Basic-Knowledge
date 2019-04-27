package com.itheima.service.impl;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;

public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao;
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	/**
	 * spring 底层使用transactionTemplate事物模板进行操作
	 * 
	 * 操作：
	 * 	1.service需要TransactionTemplate
	 * 	2.spring配置模板并注入给service
	 * 	3.模板需要事务管理器
	 * 	4.配置事物管理器：DatatSourceTrancactionManager
	 * 
	 */

	//模板
	private TransactionTemplate transactionTemplate;
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}
	

	@Override
	// 内部类里面使用外部类的局部变量时，其实就是内部类的对象在使用它，内部类对象生命周期中都可能
	//		调用它，而内部类试图访问外部方法中的局部变量时，外部方法的局部变量很可能已经不存在了，
	//		那么就得延续其生命，拷贝到内部类中，而拷贝会带来不一致性，从而需要使用final声明保证一致性。
	public void transfer(final String outer,final String inner,final int money) {
		
		//使用事物模板
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				accountDao.out(outer, money);
				//int i = 1/0;
				accountDao.in(inner, money);

			}
		});
	}

}
