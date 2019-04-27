package day12.service.impl;

import day12.dao.UserDao;
import day12.dao.impl.UserDaoImpl;
import day12.domain.User;
import day12.exception.UserExistException;
import day12.service.UserService;

public class UserServiceImpl implements UserService{
	
	UserDao userDao = new UserDaoImpl();
	
	@Override
	public void register(User user) throws Exception{
		
		try {
			userDao.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}//ע��ʱ����û�
		
	}

	@Override
	public User login(User user) {
		//��¼ʱУ���û�
		User u = null;
		
		try {
			u = userDao.findUser(user);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return u;
	}

	@Override
	public boolean findUserByName(String username) throws UserExistException {
		
		boolean b = userDao.fiandUserByName(username);
		
		if(b){
			throw new UserExistException("�û����Ѵ���");
		}
		return b;
	}
	
	
	

}
