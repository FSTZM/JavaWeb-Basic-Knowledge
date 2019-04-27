package com.itheima.mapper;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.po.User;

public class UserMapperTest {
	
	private ApplicationContext application;

	@Before
	public void setUp() throws Exception {
		application = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	}

	@Test
	public void testFindUserById() {
		
		UserMapper userMapper = (UserMapper) application.getBean("userMapper");
		User user = userMapper.findUserById(1);
		System.out.println(user);
		
	}

}


