
package com.nicchagil.mybatis3spring3intg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nicchagil.mybatis3spring3intg.bean.User;
import com.nicchagil.mybatis3spring3intg.mapper.UserMapper;
import com.nicchagil.mybatis3spring3intg.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper mapper;
	
	@Override
	public User query(String username) {
		return mapper.find(username);
	}
	
	@Override
	public void save(User user) {
		mapper.save(user);
	}

	@Override
	@Transactional
	public void testTransaction(User user1, User user2) {
		mapper.save(user1);
		
		// Code a NullPointerException to test transaction setting
		String str = null;
		str.charAt(0);
		
		mapper.save(user2);
	}
	
}
