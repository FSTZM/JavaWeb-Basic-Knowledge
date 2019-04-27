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
	
		//����properties�ļ�
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
	
	
	//�����������������ӷ������η���Ҫô�Ͱ���仰�ŵ����������棬����Ҫ��static���β���ֱ��������
	//�õ����Ӱ취
	public static Connection getConnection() throws Exception{
		return DriverManager.getConnection(url, username, password);
	}
	
	
	//�ر���Դ
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
