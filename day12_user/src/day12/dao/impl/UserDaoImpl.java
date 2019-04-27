package day12.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import org.apache.commons.beanutils.BeanUtils;

import day12.dao.UserDao;
import day12.domain.User;
import day12.utils.DBUtils;
import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class UserDaoImpl implements UserDao{
	
	/**
	 * 1.方法executeQuery 
	 *   用于产生单个结果集（ResultSet）的语句，例如:被执行最多的SELECT 语句
	 *   这个方法被用来执行 SELECT 语句，但也只能执行查询语句，执行后返回代表查询结果的ResultSet对象。
	 *   
	 * 2.方法executeUpdate
	 *   用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句，例如 CREATE TABLE 和 DROP TABLE。
	 *   INSERT、UPDATE 或 DELETE 语句的效果是修改表中零行或多行中的一列或多列。
	 *   executeUpdate 的返回值是一个整数（int），指示受影响的行数（即更新计数）。
	 *   对于 CREATE TABLE 或 DROP TABLE 等不操作行的语句，executeUpdate 的返回值总为零。
	 *   
	 * 3.方法execute(不常用)
	 *   可用于执行任何SQL语句，返回一个boolean值，表明执行该SQL语句是否返回了ResultSet。
     *   如果执行后第一个结果是ResultSet，则返回true，否则返回false。
	 */
	
	/**
	 * Statement 和 PreparedStatement之间的关系和区别.
	 *    关系：PreparedStatement继承自Statement,都是接口
	 *	    区别：PreparedStatement可以使用占位符，是预编译的，批处理比Statement效率高
	 */

	@Override
	public void addUser(User user) throws Exception{
		
		//JDBC方法
		Connection conn = null;
		PreparedStatement ps = null;
		
		
		try {
			//加载驱动创建连接
			conn = DBUtils.getConnection();
			//生成statement
			ps = conn.prepareStatement("insert into users(name,password,email,birthday) values(?,?,?,?)");
			//添加数据
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			
			//时间格式
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date = sdf.format(user.getBirthday());
			ps.setString(4, date);
			
			//执行sql
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			//抛出异常
			throw new RuntimeException("添加失败！");
			
		} finally{
			//关闭连接
			DBUtils.closeAll(conn, ps, null);
		}
		
	}

	@Override
	public User findUser(User user)  throws Exception{
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		User u = new User();
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("select * from users where name=? and password=?");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			rs = ps.executeQuery();
			
			if(rs.next()){
				u = new User();
				u.setId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setBirthday(rs.getDate(5));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtils.closeAll(conn, ps, rs);
		}

		return u;	
	}

	@Override
	public boolean fiandUserByName(String name) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("select * from users where name=?");
			ps.setString(1, name);
			rs = ps.executeQuery();
			
			if(rs.next()){
				return true;
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.closeAll(conn, ps, rs);
		}
		
		return false;
	}
	

}
