package jdbcdemo;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import entity.User;



public class test1{

	@Test
	public void t() throws Exception{
		//�������� -- �÷�����Ƽ�����
		Class.forName("com.mysql.jdbc.Driver");
		
		
		//��ȡ����Connection
		java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb6","root","123");
		
		
		//�õ�ִ��sql���Ķ���Statement
		Statement stmt = conn.createStatement();
		
		
		//ִ��sql��䣬�����ؽ��
		ResultSet rs = stmt.executeQuery("select password,email,birthday,id,name,name from users");
		
		List<User> list = new ArrayList<User>();
		
		
		//������
		while(rs.next()){
			
			User u = new User(); //����while����
			
			u.setID(rs.getInt("ID"));
			u.setName(rs.getString("name"));
			u.setPassword(rs.getString("password"));
			u.setEmail(rs.getString("email"));
			u.setBirthday(rs.getDate("birthday"));
			list.add(u);
			
		}
		
		
		//�ر���Դ
		rs.close();
		stmt.close();
		conn.close();
		
		for(User user : list){
			System.out.println(user);
		}
	
		}
	
	
	@Test
	public void t1(){
		
		java.sql.Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			//�������� -- �÷�����Ƽ�����
			Class.forName("com.mysql.jdbc.Driver");
			
			
			//��ȡ����Connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb6","root","123");
			
			
			//�õ�ִ��sql���Ķ���Statement
			stmt = conn.createStatement();
			
			
			//ִ��sql��䣬�����ؽ��
			rs = stmt.executeQuery("select password,email,birthday,id,name,name from users");
			
			List<User> list = new ArrayList<User>();
			
			
			//������
			rs.afterLast();
			rs.previous();
			
				User u = new User();
				
				u.setID(rs.getInt("ID"));
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				u.setBirthday(rs.getDate("birthday"));
				list.add(u);
				
			
			System.out.println(u);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			//�ر���Դ
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	
		}
}
	

