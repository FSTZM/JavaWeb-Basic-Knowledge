package test;

import java.sql.SQLException;

import service.AccountService;
import service.impl.AccountServiceImpl;

public class Transfer {

	public static void main(String[] args) throws Exception {
		AccountService as = new AccountServiceImpl();
		as.transferAccount("aaa", "bbb", 500);
	}

}
