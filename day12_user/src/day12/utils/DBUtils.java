package day12.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DBUtils {
	
	private static String driverClass;
	private static String url;
	private static String username;
	private static String password;
	
	static{
	
		//加载properties文件
		ResourceBundle rb = ResourceBundle.getBundle("dbinfo");
		
		driverClass = rb.getString("driverClass");
		url = rb.getString("url");
		username = rb.getString("username");
		password = rb.getString("password");
		
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	//方法里声明方法不加访问修饰符。要么就把这句话放到方法的外面，但是要加static修饰才能直接引用了
	//得到连接办法
	public static Connection getConnection() throws Exception{
		return DriverManager.getConnection(url, username, password);
	}
	
	
	//关闭资源
	public static void closeAll(Connection conn, Statement stat, ResultSet rs){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(stat!=null){
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	
}
