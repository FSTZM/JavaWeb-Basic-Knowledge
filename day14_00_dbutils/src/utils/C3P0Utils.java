package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
	
	private static DataSource dataSource = new ComboPooledDataSource();
	
	//�õ�һ������Դ
	public static DataSource getDataSource(){
		return dataSource;
	}
	
	//�õ�һ�����Ӷ���
	private static Connection getConnection(){
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("����������");
		}
		
	}
	
	//�ر���Դ
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
				conn.close();//�ر�
			} catch (Exception e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}

}
