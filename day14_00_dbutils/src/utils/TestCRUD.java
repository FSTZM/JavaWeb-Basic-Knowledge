package utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import entity.Users;

public class TestCRUD {

	@Test
	public void testSelect1() throws SQLException{
		
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		
		List<Users> list = qr.query("select * from users", new ResultSetHandler<List<Users>>(){

			@Override
			public List<Users> handle(ResultSet rs) throws SQLException {

				List<Users> list = new ArrayList<Users>();
				
				while(rs.next()){
					Users u = new Users();
					u.setId(rs.getInt(1));
					u.setName(rs.getString(2));
					u.setPassword(rs.getString(3));
					u.setEmail(rs.getString(4));
					u.setBirthday(rs.getDate(5));
					
					list.add(u);
				}
				
				return list;
			}
			
		});
		
		for (Users user : list) {
			System.out.println(user);
		}
		
	}
	
	
	@Test
	public void testSelect2() throws SQLException{
		
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		List<Users> list = qr.query("select * from users", new BeanListHandler<Users>(Users.class));
		
		for (Users users : list) {
			System.out.println(users);
		}
	}
	
}
