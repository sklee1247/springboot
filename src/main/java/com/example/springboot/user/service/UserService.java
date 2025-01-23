package com.example.springboot.user.service;

import org.springframework.stereotype.Service;

import com.example.springboot.user.dao.UserMapper;
import com.example.springboot.user.model.Users;

@Service
public class UserService {
	
	private final UserMapper userMapper;
	
	public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
	
	public Users findUser(Users users) throws Exception {
		return userMapper.findUser(users);
	}
	
	public void userSave(Users users) throws Exception {
		userMapper.saveUser(users);
	}
}
