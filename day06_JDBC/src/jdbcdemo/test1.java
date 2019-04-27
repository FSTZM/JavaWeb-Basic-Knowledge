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
		//加载驱动 -- 用反射机制加载类
		Class.forName("com.mysql.jdbc.Driver");
		
		
		//获取连接Connection
		java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb6","root","123");
		
		
		//得到执行sql语句的对象Statement
		Statement stmt = conn.createStatement();
		
		
		//执行sql语句，并返回结果
		ResultSet rs = stmt.executeQuery("select password,email,birthday,id,name,name from users");
		
		List<User> list = new ArrayList<User>();
		
		
		//处理结果
		while(rs.next()){
			
			User u = new User(); //放在while里面
			
			u.setID(rs.getInt("ID"));
			u.setName(rs.getString("name"));
			u.setPassword(rs.getString("password"));
			u.setEmail(rs.getString("email"));
			u.setBirthday(rs.getDate("birthday"));
			list.add(u);
			
		}
		
		
		//关闭资源
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
			//加载驱动 -- 用反射机制加载类
			Class.forName("com.mysql.jdbc.Driver");
			
			
			//获取连接Connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb6","root","123");
			
			
			//得到执行sql语句的对象Statement
			stmt = conn.createStatement();
			
			
			//执行sql语句，并返回结果
			rs = stmt.executeQuery("select password,email,birthday,id,name,name from users");
			
			List<User> list = new ArrayList<User>();
			
			
			//处理结果
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
			//关闭资源
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
	

