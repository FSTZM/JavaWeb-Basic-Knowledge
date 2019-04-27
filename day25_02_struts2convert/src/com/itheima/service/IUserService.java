package com.itheima.service;

import com.itheima.domian.User;

/**
 * 用户相关操作的业务层接口
 * @author Diane
 *
 */

public interface IUserService {

	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	User findUserByUsername(String username);
	
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	int register(User user);
	
	
}
