package threadlocal;

import java.sql.Connection;
import java.sql.SQLException;

import utils.C3P0Utils;

public class ManagerThreadLocal {
	
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	//�õ�һ������
	public static Connection getConnection(){
		Connection conn = tl.get();
		if(conn==null){
			conn = C3P0Utils.getConnection();
			tl.set(conn);
		}
		
		return conn;
	}
	
	//��������
	public static void StartTransacation(){
		Connection conn = getConnection();
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//�ύ����
	public static void CommitTransacation(){
		Connection conn = getConnection();
		try {
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//�ع�����
	public static void RoolBackTransacation(){
		Connection conn = getConnection();
		try {
			conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//�ر�����
	public static void release(){
		Connection conn = getConnection();
		try {
			conn.close();//�����ӷŻس���
			tl.remove();//�Ƴ���ǰ�̶߳����е�conn
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
