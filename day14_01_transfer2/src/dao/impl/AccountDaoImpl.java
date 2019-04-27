package dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import dao.AccountDao;
import domain.Account;
import utils.C3P0Utils;

public class AccountDaoImpl implements AccountDao{

	private Connection conn;

	public AccountDaoImpl(Connection conn) {
		this.conn = conn;
	}

	public void updateAccount(String inName, String outName, int money) throws SQLException {
		
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		qr.update("update account set money=money-? where name=?", money,outName);
		qr.update("update account set money=money+? where name=?", money,inName);
		
	}

	@Override
	public void updateAccount(Account account) throws SQLException {
		
		QueryRunner qr = new QueryRunner();
		qr.update(conn, "update account set money=? where name=?", account.getMoney(),account.getName());		
		
	}

	@Override
	public Account findAccountByName(String name) throws SQLException {
		QueryRunner qr = new QueryRunner();
		return qr.query(conn, "select * from account where name=?", new BeanHandler<Account>(Account.class),name);
	}


}
