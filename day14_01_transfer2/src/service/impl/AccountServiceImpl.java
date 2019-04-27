package service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import dao.AccountDao;
import dao.impl.AccountDaoImpl;
import domain.Account;
import service.AccountService;
import utils.C3P0Utils;

public class AccountServiceImpl implements AccountService {
	
	@Override
	public void transferAccount(String inName, String outName, int money){

//		ad.updateAccount(inName, outName, money);

		Connection conn = C3P0Utils.getConnection();
		AccountDao ad = new AccountDaoImpl(conn);
		
		try {
			
			conn.setAutoCommit(false);
			
			//得到账户信息
			Account outAccount = ad.findAccountByName(outName);
			Account inAccount = ad.findAccountByName(inName);
			
			//设置转账金额
			outAccount.setMoney(outAccount.getMoney()-money);
//			int i = 10/0;
			inAccount.setMoney(inAccount.getMoney()+money);
			
			
			//转账成功
			ad.updateAccount(inAccount);
			ad.updateAccount(outAccount);
			
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} finally{			
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		
	}


}
