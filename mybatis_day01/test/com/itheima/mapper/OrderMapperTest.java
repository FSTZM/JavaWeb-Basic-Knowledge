package com.itheima.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.itheima.po.Orderdetail;
import com.itheima.po.OrdersExt;
import com.itheima.po.User;

public class OrderMapperTest {

	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void setup() throws Exception {
		String resource = "sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void testFindOrdersAndUser() {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
		List<OrdersExt> list = mapper.findOrdersAndUser();
		
		System.out.println(list);
		
		sqlSession.close();
		
	}
	
	@Test
	public void testFindOrdersAndUserRstMap() {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
		List<OrdersExt> list = mapper.findOrdersAndUserRstMap();
		
		System.out.println(list);
		
		sqlSession.close();
		
	}
	
	@Test
	public void testFindOrderAndDetail() {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
		List<OrdersExt> list = mapper.findOrderAndDetail();
		
		System.out.println(list);
		
		sqlSession.close();
		
	}
	
	@Test
	public void testFindUserAndItemsRstMap() {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
		List<User> list = mapper.findUserAndItemsRstMap();
		
		System.out.println(list);
		
		sqlSession.close();
		
	}

}
