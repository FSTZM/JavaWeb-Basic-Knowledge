package threadlocal;

import java.sql.Connection;
import java.sql.SQLException;

import utils.C3P0Utils;

public class ManagerThreadLocal {
	
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	//得到一个连接
	public static Connection getConnection(){
		Connection conn = tl.get();
		if(conn==null){
			conn = C3P0Utils.getConnection();
			tl.set(conn);
		}
		
		return conn;
	}
	
	//启动事务
	public static void StartTransacation(){
		Connection conn = getConnection();
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//提交事务
	public static void CommitTransacation(){
		Connection conn = getConnection();
		try {
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//回滚事务
	public static void RoolBackTransacation(){
		Connection conn = getConnection();
		try {
			conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//关闭事务
	public static void release(){
		Connection conn = getConnection();
		try {
			conn.close();//把链接放回池中
			tl.remove();//移除当前线程对象中的conn
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
