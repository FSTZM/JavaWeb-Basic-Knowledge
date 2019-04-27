package com.itheima.helloworld;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

public class test01 {
	
	@Test
	public void fun(){

		//1.读取配置文件
		Configuration conf = new Configuration().configure();
		//2.根据配置文件创建factory
		SessionFactory sessionFactory = conf.buildSessionFactory();
		//3.获取数据库的session
		Session session = sessionFactory.openSession();
		//4.操作数据库
		User u = new User();
		u.setUsername("tom");
		u.setPassword("123");
		session.save(u);
		//5.关闭资源
		session.close();
		sessionFactory.close();
	}

}
