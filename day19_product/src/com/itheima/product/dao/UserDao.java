package com.itheima.product.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.product.domain.User;
import com.itheima.product.util.C3P0Utils;

public class UserDao {
	/*
	 * QueryRunner�ࣨ������query��ѯ��update��ɾ�ĺ�batch��������
	 * ResultSetHandler�ӿڣ�����select����η�װ���ݵģ��� DBUtils�ࣨ�����˹ر���Դ��������ķ�����
	 */

	public void addUser(User user) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "INSERT INTO USER(username,PASSWORD,gender,email,telephone,"
				+ "introduce,activeCode,state,registTime) VALUES(?,?,?,?,?,?,?,?,?);";
		qr.update(sql, user.getUsername(), user.getPassword(), user.getGender(), user.getEmail(), user.getTelephone(),
				user.getIntroduce(), user.getActiveCode(), user.getState(),user.getRegistTime());
	}

	public User findUserByActiveCode(String activeCode) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		
		return qr.query("select * from user where activeCode=?", new BeanHandler<User>(User.class),activeCode);
	}

	public void activeUser(String activeCode) throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		qr.update("update user set state=1 where activeCode=?", activeCode);
	}

	public User findUserByUserNameAndPassword(String username, String password) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		
		return qr.query("select * from user where username=? and password=?", new BeanHandler<User>(User.class),username,password);
	}

	public User finUserById(String id) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		return qr.query("select * from user where id=?",new BeanHandler<User>(User.class),id);
	}

	public void modifyUser(User user) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		qr.update("update user set password=?,gender=?,telephone=? where id=?", user.getPassword(),user.getGender(),user.getTelephone(),user.getId());
	}

	


}
