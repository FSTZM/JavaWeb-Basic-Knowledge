package dao;

import java.sql.SQLException;

public interface AccountDao {
	
	/**
	 * ת��
	 * ת���˻� inName
	 * ת���˻� outName
	 * ת�˽�� money
	 * @throws SQLException 
	 */

	public void updateAccount(String inName, String outName, int money) throws SQLException;
	
	

}
