package com.itheima.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.itheima.dao.UserDao;
import com.itheima.po.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Override
	public User findUserById(int id) {

		return this.getSqlSession().selectOne("test.findUserById", 1);
	}

}
