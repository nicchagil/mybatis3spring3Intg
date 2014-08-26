package com.nicchagil.mybatis3spring3intg.mapper;

import com.nicchagil.mybatis3spring3intg.bean.User;

public interface UserMapper {
	
	public User find(String username);
	
	public void save(User user);

}
