package com.itheima.dao.impl;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;

public class UserDaoImpl implements UserDao{

	//模板 hibernateTemplate，需要spring注入模板
	//spring提供hibernateTemplate模板用来操作PO对象，类似于HibernateSession对象
	
	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public void save(User user) {
		this.hibernateTemplate.save(user);
	}

}
