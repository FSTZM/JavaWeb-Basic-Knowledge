package dao;

import java.sql.SQLException;

import domain.Account;

public interface AccountDao {
	
	/**
	 * 转账
	 * 转入账户 inName
	 * 转出账户 outName
	 * 转账金额 money
	 * @throws SQLException 
	 */
	@Deprecated
	public void updateAccount(String inName, String outName, int money) throws SQLException;
	
	/**
	 * 根据账户信息修改金额
	 * @throws SQLException 
	 */
	public void updateAccount(Account account) throws SQLException;
	
	/**
	 * 根据用户名查找账户
	 * @throws SQLException 
	 */
	public Account findAccountByName(String name) throws SQLException;
}
