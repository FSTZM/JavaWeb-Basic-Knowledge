package com.itheima.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.itheima.po.User;

public class test {

	@Test
	public void findUserById() throws Exception{
		
		//读取配置文件
		String resource = "sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//创建SQLSession会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//调用SQLSession的增删改查方法
		//test是User.xml映射文件的命名空间
		User user = sqlSession.selectOne("test.findUserById", 1);
		System.out.println(user);
		//关闭资源：频繁关闭开启数据库是很耗费资源的，但是此处的不是关闭数据库，数据库是一直开着的，只是关闭了一个 sqlSession会话
		sqlSession.close();
	}
	
	
	
	@Test
	public void findUsersByName() throws Exception{
		
		//获取全局配置文件路径
		String resource = "sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//获得SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//获得SQLSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//获得增删改查
		List<User> users = sqlSession.selectList("test.findUsersByName", "小明");
		System.out.println(users);
		//关闭资源
		sqlSession.close();
	}
	
	
	@Test
	public void insertUser() throws Exception{
		
		//读取配置文件
		String resource = "sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//创建SQLSession会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//增加用户
		User user = new User();
		user.setUsername("tom");
		user.setSex("1");
		user.setBirthday(null);
		user.setAddress("xian");
		
		//调用SQLSession的增删改查方法
		//test是User.xml映射文件的命名空间
		sqlSession.insert("test.insertUser",user);
		
		System.out.println(user.getId());
		
		//增加了数据要提交：commit
		sqlSession.commit();
		
		
		//关闭资源：频繁关闭开启数据库是很耗费资源的，但是此处的不是关闭数据库，数据库是一直开着的，只是关闭了一个 sqlSession会话
		sqlSession.close();
	}
	

}
