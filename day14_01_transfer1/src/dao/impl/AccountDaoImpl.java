package dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import dao.AccountDao;
import utils.C3P0Utils;

public class AccountDaoImpl implements AccountDao{

	public void updateAccount(String inName, String outName, int money) throws SQLException {
		
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		qr.update("update account set money=money-? where name=?", money,outName);
		qr.update("update account set money=money+? where name=?", money,inName);
		
	}

}
