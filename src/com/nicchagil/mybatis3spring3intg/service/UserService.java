package com.nicchagil.mybatis3spring3intg.service;

import com.nicchagil.mybatis3spring3intg.bean.User;

public interface UserService {
	
	public User query(String username);
	
	public void save(User user);
	
	public void testTransaction(User user1, User user2);

}
