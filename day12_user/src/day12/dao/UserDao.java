package day12.dao;

import day12.domain.User;

public interface UserDao {
	
	/**
	 * 添加用户
	 * @throws Exception 
	 */
	public void addUser(User user) throws Exception;
	
	/**
	 * 根据用户名和密码查找用户信息
	 */
	public User findUser(User user) throws Exception;
	
	/**
	 * 根据用户名查找用户是否存在
	 */
	public boolean fiandUserByName(String username) ;
	

}
