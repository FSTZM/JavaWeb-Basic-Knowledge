package jdbcdemo;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;




//ʹ��JDBC����ʵ�ֲ�ѯ���ݿ����ݣ�����ʾ�ڿ���̨��



public class demo2 {

	@Test
	public void Test1() throws Exception{
		// TODO Auto-generated method stub
		
		//�������� -- �÷�����Ƽ�����
		Class.forName("com.mysql.jdbc.Driver");
		
		
		//��ȡ����Connection
		java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb6","root","123");
		
		
		//�õ�ִ��sql���Ķ���Statement
		Statement stmt = conn.createStatement();
		
		
		//ִ��sql��䣬�����ؽ��
		ResultSet rs = stmt.executeQuery("select * from users");
		
		
		//������
		while(rs.next()){
			System.out.println(rs.getObject(1));
			System.out.println(rs.getObject(2));
			System.out.println(rs.getObject(3));
			System.out.println(rs.getObject(4));
			System.out.println(rs.getObject(5));
		}
		
		
		//�ر���Դ
		rs.close();
		stmt.close();
		conn.close();

	}
	
	
	@Test
	public void Test2() throws Exception{
		// TODO Auto-generated method stub
		
		//�������� -- �÷�����Ƽ�����
		Class.forName("com.mysql.jdbc.Driver");
		
		//
		Properties info = new Properties();
		info.setProperty("user", "root");
		info.setProperty("password","123");
		java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb6",info);
		
		//�õ�ִ��sql���Ķ���Statement
		Statement stmt = conn.createStatement();
		
		
		//ִ��sql��䣬�����ؽ��
		ResultSet rs = stmt.executeQuery("select * from users");
		
		
		//������
		while(rs.next()){
			System.out.println(rs.getObject(1));
			System.out.println(rs.getObject(2));
			System.out.println(rs.getObject(3));
			System.out.println(rs.getObject(4));
			System.out.println(rs.getObject(5));
		}
		
		
		//�ر���Դ
		rs.close();
		stmt.close();
		conn.close();

	}
	
	@Test
	public void Test3() throws Exception{
		
		//�������� -- �÷�����Ƽ�����
		Class.forName("com.mysql.jdbc.Driver");
		
		
		//��ȡ����Connection
		java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb6?user=root&password=123");
		
		
		//�õ�ִ��sql���Ķ���Statement
		Statement stmt = conn.createStatement();
		
		
		//ִ��sql��䣬�����ؽ��
		ResultSet rs = stmt.executeQuery("select * from users");
		
		
		//������
		while(rs.next()){
			System.out.println(rs.getObject(1));
			System.out.println(rs.getObject(2));
			System.out.println(rs.getObject(3));
			System.out.println(rs.getObject(4));
			System.out.println(rs.getObject(5));
		}
		
		
		//�ر���Դ
		rs.close();
		stmt.close();
		conn.close();

	}
	

}
