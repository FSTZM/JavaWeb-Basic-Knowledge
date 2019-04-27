package com.itheima.service;

import java.util.List;

import com.itheima.domain.User;

/**
 * 用户操作相关业务层接口
 * 
 	用户登录
	保存用户
	修改用户
	根据用户id，删除用户
	根据用户id，获取用户信息
	查询所有用户
	根据条件查询用户信息

 * @author Diane
 *
 */
public interface IUserService {
	
	/**
	 * 用户登录
	 * @param logonName
	 * @param logonPwd
	 * @return
	 */
	User login(String logonName,String logonPwd);
	
	/**
	 * 保存用户，直接就是user对象
	 * @param user
	 * @return
	 */
	int saveUser(User user);
	
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	int modifyUser(User user);
	
	/**
	 * 删除用户
	 * @param userID
	 * @return
	 */
	int removeUser(Integer userID);
	
	/**
	 * 根据ID查找用户信息
	 * @param userID
	 * @return
	 */
	User findUserById(Integer userID);
	
	/**
	 * 查找所有用户信息
	 * @return
	 */
	List<User> findAllUser();
	
	/**
	 * 根据条件查找用户
	 * @param userName
	 * @param gender
	 * @param education
	 * @param isUpload
	 * @return
	 */
	List<User> findUserByCondition(String userName,String gender,String education,String isUpload);
	
	
	

}
