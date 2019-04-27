package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import entity.User;
import util.DBUtils;

public class Dologin {
	
	public User findUser(String name,String password){
		
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		User u = null;
		try {
			conn = DBUtils.getConnection();
			
			String sql = "select * from users where name=? and password=?";
			
			stat = conn.prepareStatement(sql);
			//¸ø?¸³Öµ
			stat.setString(1, name);
			stat.setString(2, password);
			
			
			rs = stat.executeQuery();
			
			if(rs.next()){
				u = new User();
				u.setID(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setBirthday(rs.getDate(5));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtils.closeAll(rs, stat, conn);
		}
		
		return u;
	}

}













