package dao;

import java.sql.SQLException;

public interface AccountDao {
	
	/**
	 * 转账
	 * 转入账户 inName
	 * 转出账户 outName
	 * 转账金额 money
	 * @throws SQLException 
	 */

	public void updateAccount(String inName, String outName, int money) throws SQLException;
	
	

}
