package jdbcdemo;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

//使用JDBC技术实现查询数据库数据，并显示在控制台上


public class demo1 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		//注册驱动
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		
		
		//获取连接Connection
		java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb6","root","123");
		
		
		//得到执行sql语句的对象Statement
		Statement stmt = conn.createStatement();
		
		
		//执行sql语句，并返回结果
		ResultSet rs = stmt.executeQuery("select * from users");
		
		
		//处理结果
		while(rs.next()){
			System.out.println(rs.getObject(1));
			System.out.println(rs.getObject(2));
			System.out.println(rs.getObject(3));
			System.out.println(rs.getObject(4));
			System.out.println(rs.getObject(5));
		}
		
		
		//关闭资源
		rs.close();
		stmt.close();
		conn.close();

	}

}
