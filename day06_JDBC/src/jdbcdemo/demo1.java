package jdbcdemo;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

//ʹ��JDBC����ʵ�ֲ�ѯ���ݿ����ݣ�����ʾ�ڿ���̨��


public class demo1 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		//ע������
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		
		
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

}
