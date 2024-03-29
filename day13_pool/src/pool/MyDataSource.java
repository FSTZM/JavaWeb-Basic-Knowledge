package pool;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.sql.DataSource;

import utils.DBUtils;

public class MyDataSource implements DataSource{
	
	private static LinkedList<Connection> pool = (LinkedList<Connection>) Collections.synchronizedList(new LinkedList<Connection>());

	static{
		
		for (int i = 0; i < 10; i++) {
			try {
				Connection conn = DBUtils.getConnection();
				
				pool.add(conn);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new ExceptionInInitializerError("初始化数据库连接失败！");
			}
		}	
	}
	
	public Connection getConnection() throws SQLException {
		
		Connection conn = null;
		if(pool.size()>0){
			conn  = pool.removeFirst();
			MyConnection myConn = new MyConnection(conn, pool);
			return myConn;
		} else{
			throw new RuntimeException("服务器繁忙！");
		}
	
	}
	
	
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
		

}
