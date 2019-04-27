package dao;

import java.sql.SQLException;

import domain.Account;

public interface AccountDao {
	
	/**
	 * ת��
	 * ת���˻� inName
	 * ת���˻� outName
	 * ת�˽�� money
	 * @throws SQLException 
	 */
	@Deprecated
	public void updateAccount(String inName, String outName, int money) throws SQLException;
	
	/**
	 * �����˻���Ϣ�޸Ľ��
	 * @throws SQLException 
	 */
	public void updateAccount(Account account) throws SQLException;
	
	/**
	 * �����û��������˻�
	 * @throws SQLException 
	 */
	public Account findAccountByName(String name) throws SQLException;
}
