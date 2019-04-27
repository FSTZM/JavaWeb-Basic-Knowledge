package pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;


public class testJDBC {
	
	@Test
	public void test1(){
	
		Connection conn = null;
		PreparedStatement ps = null;
	
		DataSource ds = new MyDataSource();
		
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement("sql");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
	
	

}
