package com.itheima.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

	//模板 hibernateTemplate，需要spring注入模板
	//spring提供hibernateTemplate模板用来操作PO对象，类似于HibernateSession对象
	
	/*private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}*/
	
	
	//底层实现：配置spring 自动创建模板
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}

}
