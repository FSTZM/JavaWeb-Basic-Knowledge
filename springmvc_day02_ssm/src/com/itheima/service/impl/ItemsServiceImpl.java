package com.itheima.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itheima.mapper.ItemsMapper;
import com.itheima.po.Items;
import com.itheima.service.ItemsService;

@Service("ItemsService")
public class ItemsServiceImpl implements ItemsService{

	//需要注入代理对象
	@Resource
	private ItemsMapper itemsMapper;
	
	@Override
	public List<Items> findAll() {
		
		List<Items> list = itemsMapper.findAll();
		
		return list;
	}

}
