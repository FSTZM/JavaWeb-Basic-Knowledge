package jdbcdemo;

import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.Test;


public class TestCRUD {

	@Test
	public void demo1() throws Exception{
		//
		Class.forName("com.mysql.jdbc.Driver");
		//
		java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb6?user=root&password=123");
		//
		Statement stat = conn.createStatement();
		//
		int i = stat.executeUpdate("INSERT INTO users VALUES(4,'tom','123','tom@163.com','2015-09-28')");
		if(i>0){
			System.out.println("success");
		}
		
		
		//

		stat.close();
		conn.close();
	}
	
	@Test
	public void demo2() throws Exception{
		//
		Class.forName("com.mysql.jdbc.Driver");
		//
		java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb6?user=root&password=123");
		//
		Statement stat = conn.createStatement();
		//
		int i = stat.executeUpdate("UPDATE users SET NAME='jerry',PASSWORD='333',email='jerry@163.com' WHERE id=4");
		if(i>0){
			System.out.println("success");
		}else{
			System.out.println("ÐÞ¸ÄÁË"+i+"ÐÐ");
		}
		
		
		//

		stat.close();
		conn.close();
	}
	
	@Test
	public void demo3() throws Exception{
		//
		Class.forName("com.mysql.jdbc.Driver");
		//
		java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb6?user=root&password=123");
		//
		Statement stat = conn.createStatement();
		//
		int i = stat.executeUpdate("UPDATE users SET NAME='jerry',PASSWORD='333',email='jerry@163.com' WHERE id=4");
		if(i>0){
			System.out.println("success");
		}
		
		
		//
		stat.close();
		conn.close();
	}
	
}
