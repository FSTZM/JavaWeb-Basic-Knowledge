package com.itheima.dao.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.itheima.dao.AccountDao;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

	@Override
	public void in(String inner, int money) {
		this.getJdbcTemplate().update("update account set money = money + ? where username = ? ", money,inner);
	}

	@Override
	public void out(String outer, int money) {
		this.getJdbcTemplate().update("update account set money = money-? where username = ? ", money,outer);
	}

}
