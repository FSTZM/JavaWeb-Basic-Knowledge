package com.itheima.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.itheima.dao.IUserDao;
import com.itheima.domian.User;
import com.itheima.utils.DBCPUtil;

public class IUserDaoImpl implements IUserDao {

	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());

	@Override
	public User selectUserByUsername(String username) {
		try {
			return qr.query("select * from user where username=?", new BeanHandler<User>(User.class), username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int addUser(User user) {
		try {
			return qr.update("insert into user(username,password,birthday,hobby,married) values(?,?,?,?,?)",
					user.getUsername(), user.getPassword(), user.getBirthday(), user.getHobby(), user.isMarried());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
