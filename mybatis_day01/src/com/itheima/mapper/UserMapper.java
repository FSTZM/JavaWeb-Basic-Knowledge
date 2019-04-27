package com.itheima.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itheima.po.User;
import com.itheima.po.UserQueryVO;

public interface UserMapper {
	
	public User findUserById(int id);
	
	public void insertUser(User user);
	
	public List<User> findUserList(UserQueryVO vo);
	
	public User findUserRstMap(int id);

}
