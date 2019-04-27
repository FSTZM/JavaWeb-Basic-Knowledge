package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
	
	private static DataSource dataSource = new ComboPooledDataSource();
	
	//得到一个数据源
	public static DataSource getDataSource(){
		return dataSource;
	}
	
	//得到一个连接对象
	private static Connection getConnection(){
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("服务器错误");
		}
		
	}
	
	//关闭资源
	private static void release(Connection conn, Statement ps, ResultSet rs){
		
		if(rs!=null){
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			ps = null;
		}
		if(conn!=null){
			try {
				conn.close();//关闭
			} catch (Exception e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}

}
