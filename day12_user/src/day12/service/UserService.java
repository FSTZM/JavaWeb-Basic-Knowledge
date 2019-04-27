package day12.service;

import day12.domain.User;
import day12.exception.UserExistException;
import day12.exception.UsersException;

public interface UserService {
	
	public void register(User user) throws Exception;
	
	public User login(User user) throws UsersException;
	
	public boolean findUserByName(String name) throws UserExistException;

}
