package DBCPUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class dbcpUtils {
	
	private static DataSource ds = null;
	
	static{
		Properties prop = new Properties();
		try {
			prop.load(dbcpUtils.class.getClassLoader().getResourceAsStream("dbcpcongig"));
			
			ds = BasicDataSourceFactory.createDataSource(prop);
			
		} catch (Exception e) {
			throw new ExceptionInInitializerError("初始化错误！");
		}
		
	}
	
	public static Connection getConnection(){

		try {
			return ds.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("服务器忙！");
		}
		
	}
	
	public static void release(Connection conn, Statement ps, ResultSet rs){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(ps!=null){
			try {
				ps.close();
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
