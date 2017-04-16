package com.account.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.bean.User;
import com.account.mapper.IUserMapper;
import com.account.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	private IUserMapper userMapper;
	
	@Override
	public User login(String name, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkUserName(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean register(User u) {
		
		return userMapper.addUser(u) > 0 ? true : false;
	}

	@Override
	public List<User> findAllUserByName(User user) {
		return userMapper.findAllUserByName(user);
	}

	@Override
	public User findUserById(Long id) {
		return userMapper.findUserById(id);
	}

	@Override
	public boolean deleteUserById(Long id) {
		return userMapper.deleteById(id) > 0 ? true : false;
	}
	
}
