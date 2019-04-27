package com.itheima.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.po.Items;
import com.itheima.po.ItemsExample;
import com.itheima.po.ItemsExample.Criteria;

public class ItemsMapperTest {
	
	private ApplicationContext application;

	@Before
	public void setUp() throws Exception {
		application = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	}

	@Test
	public void testSelectByExample() {
		ItemsMapper mapper = (ItemsMapper) application.getBean("itemsMapper");
		ItemsExample example = new ItemsExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameLike("%背包%");
		List<Items> list = mapper.selectByExample(example);
		System.out.println(list);
	}

}


