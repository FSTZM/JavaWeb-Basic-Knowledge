package service;

import java.sql.SQLException;

public interface AccountService {
	
	public void transferAccount(String inName, String outName, int money) throws SQLException;

}
