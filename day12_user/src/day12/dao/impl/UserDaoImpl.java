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
	 * 1.����executeQuery 
	 *   ���ڲ��������������ResultSet������䣬����:��ִ������SELECT ���
	 *   �������������ִ�� SELECT ��䣬��Ҳֻ��ִ�в�ѯ��䣬ִ�к󷵻ش����ѯ�����ResultSet����
	 *   
	 * 2.����executeUpdate
	 *   ����ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ���䣬���� CREATE TABLE �� DROP TABLE��
	 *   INSERT��UPDATE �� DELETE ����Ч�����޸ı������л�����е�һ�л���С�
	 *   executeUpdate �ķ���ֵ��һ��������int����ָʾ��Ӱ��������������¼�������
	 *   ���� CREATE TABLE �� DROP TABLE �Ȳ������е���䣬executeUpdate �ķ���ֵ��Ϊ�㡣
	 *   
	 * 3.����execute(������)
	 *   ������ִ���κ�SQL��䣬����һ��booleanֵ������ִ�и�SQL����Ƿ񷵻���ResultSet��
     *   ���ִ�к��һ�������ResultSet���򷵻�true�����򷵻�false��
	 */
	
	/**
	 * Statement �� PreparedStatement֮��Ĺ�ϵ������.
	 *    ��ϵ��PreparedStatement�̳���Statement,���ǽӿ�
	 *	    ����PreparedStatement����ʹ��ռλ������Ԥ����ģ��������StatementЧ�ʸ�
	 */

	@Override
	public void addUser(User user) throws Exception{
		
		//JDBC����
		Connection conn = null;
		PreparedStatement ps = null;
		
		
		try {
			//����������������
			conn = DBUtils.getConnection();
			//����statement
			ps = conn.prepareStatement("insert into users(name,password,email,birthday) values(?,?,?,?)");
			//�������
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			
			//ʱ���ʽ
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date = sdf.format(user.getBirthday());
			ps.setString(4, date);
			
			//ִ��sql
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			//�׳��쳣
			throw new RuntimeException("���ʧ�ܣ�");
			
		} finally{
			//�ر�����
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
