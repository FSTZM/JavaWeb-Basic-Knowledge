package com.itheima.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.po.User;

public class UserDaoTest {

	private ApplicationContext application;
	
	@Before
	public void setUp() throws Exception {
		
		application = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	}

	@Test
	public void testFindUserById() {
		
		UserDao userDao = (UserDao) application.getBean("userDao");
		User user = userDao.findUserById(1);
		System.out.println(user);
	}

}


