package service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import dao.AccountDao;
import dao.impl.AccountDaoImpl;
import domain.Account;
import service.AccountService;
import threadlocal.ManagerThreadLocal;
import utils.C3P0Utils;

public class AccountServiceImpl implements AccountService {
	
	@Override
	public void transferAccount(String inName, String outName, int money){

//		ad.updateAccount(inName, outName, money);

//		Connection conn = C3P0Utils.getConnection();
		
		AccountDao ad = new AccountDaoImpl();
		
		
		try {
			
//			conn.setAutoCommit(false);
			
			ManagerThreadLocal.StartTransacation();
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
			
//			conn.commit();
			ManagerThreadLocal.CommitTransacation();
			
		} catch (Exception e) {
			try {
//				conn.rollback();
				ManagerThreadLocal.RoolBackTransacation();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} finally{			
			try {
//				conn.close();
				ManagerThreadLocal.release();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		
	}


}
