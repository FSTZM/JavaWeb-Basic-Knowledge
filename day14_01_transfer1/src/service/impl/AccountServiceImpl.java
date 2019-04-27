package service.impl;


import java.sql.SQLException;

import dao.AccountDao;
import dao.impl.AccountDaoImpl;
import service.AccountService;

public class AccountServiceImpl implements AccountService {

	AccountDao ad = new AccountDaoImpl();
	
	@Override
	public void transferAccount(String inName, String outName, int money) throws SQLException {

		ad.updateAccount(inName, outName, money);
	}


}
