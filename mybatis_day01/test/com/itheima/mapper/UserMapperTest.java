package com.itheima.mapper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.itheima.po.User;
import com.itheima.po.UserQueryVO;

public class UserMapperTest {

	private SqlSessionFactory sqlSessionFactory;

	// before在执行test前执行
	//setup方法应该是public的
	@Before
	public void setup() throws Exception {
		String resource = "sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void TestFindUserById() {
		// 创建mapper对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 由mybatis通过sqlsession来创建代理对象
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = mapper.findUserById(1);
		System.out.println(user);
		sqlSession.close();

	}

	@Test
	public void TestInsertUser() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setUsername("jerry");
		user.setAddress("xinzhou");

		mapper.insertUser(user);

		System.out.println(user.getId());
		
		// 增加了数据要提交：commit
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void TestFindUserList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		UserQueryVO vo = new UserQueryVO();

		User user = new User();
		user.setUsername("tom");
		user.setSex("1");
		vo.setUser(user);
		
		List<User> list = mapper.findUserList(vo);
		
		System.out.println(list);
		
		sqlSession.close();
	}
	
	@Test
	public void TestFindUserRstMap() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		
		User user = mapper.findUserRstMap(1);
		
		System.out.println(user);
		
		sqlSession.close();
	}
	
	/////////////////////////////////////////////////////////////////////////////
	

	@Test
	public void testFindUserRstMap() throws Exception {
		// 创建UserMapper对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 由mybatis通过sqlsession来创建代理对象
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);

		User user = mapper.findUserRstMap(1);
		System.out.println(user);
		sqlSession.close();
	}

	@Test
	public void testOneLevelCache() throws Exception {
		// 创建UserMapper对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 由mybatis通过sqlsession来创建代理对象
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);

		// 第一次查询
		User user1 = mapper.findUserById(1);
		System.out.println(user1);

		// 执行添加用户操作
		mapper.insertUser(user1);
		// 执行commit时，将一级缓存清空
		sqlSession.commit();

		// 第二次查询
		User user2 = mapper.findUserById(1);
		System.out.println(user2);

		sqlSession.close();
	}

	@Test
	public void testTwoLevelCache() throws Exception {
		// 创建UserMapper对象
		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		SqlSession sqlSession2 = sqlSessionFactory.openSession();
		SqlSession sqlSession3 = sqlSessionFactory.openSession();

		// 由mybatis通过sqlsession来创建代理对象
		UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
		UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
		UserMapper mapper3 = sqlSession3.getMapper(UserMapper.class);

		// 第一次查询
		User user1 = mapper1.findUserById(1);
		System.out.println(user1);
		// 在close的时候，才会将数据写入到二级缓存中
		sqlSession1.close();

		// 执行添加用户操作
		// mapper3.insertUser(user1);
		// 执行commit时，将一级缓存清空
		// sqlSession3.commit();

		// 第二次查询
		User user2 = mapper2.findUserById(1);
		System.out.println(user2);
		sqlSession2.close();

		// 关闭资源
		sqlSession3.close();
	}


}
