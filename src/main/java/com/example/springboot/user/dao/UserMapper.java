package com.example.springboot.user.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.springboot.user.model.Users;

@Mapper
public interface UserMapper {

	public Users findUser(Users users);
	
	public void saveUser(Users users);
}
