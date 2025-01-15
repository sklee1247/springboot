package com.example.springboot.common.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.springboot.common.dto.Users;

@Mapper
public interface UserMapper {

	public void findUser(Users user); // throws Exception {
//		return findUser(@param("param") Users users);
//	}
	
	public void save(Users user);
}
