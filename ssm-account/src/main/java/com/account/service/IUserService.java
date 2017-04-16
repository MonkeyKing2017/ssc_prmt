package com.account.service;

import java.util.List;

import com.account.bean.User;

public interface IUserService {
	User login(String name,String password);
	
	boolean checkUserName(String name);
	
	boolean register(User u);
	
	List<User> findAllUserByName(User user);
	
	User findUserById(Long id);
	
	boolean deleteUserById(Long id);
}
