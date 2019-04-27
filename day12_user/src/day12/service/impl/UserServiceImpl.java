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
		}//注册时添加用户
		
	}

	@Override
	public User login(User user) {
		//登录时校验用户
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
			throw new UserExistException("用户名已存在");
		}
		return b;
	}
	
	
	

}
