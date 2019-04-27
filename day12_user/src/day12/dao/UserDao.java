package day12.dao;

import day12.domain.User;

public interface UserDao {
	
	/**
	 * ����û�
	 * @throws Exception 
	 */
	public void addUser(User user) throws Exception;
	
	/**
	 * �����û�������������û���Ϣ
	 */
	public User findUser(User user) throws Exception;
	
	/**
	 * �����û��������û��Ƿ����
	 */
	public boolean fiandUserByName(String username) ;
	

}
