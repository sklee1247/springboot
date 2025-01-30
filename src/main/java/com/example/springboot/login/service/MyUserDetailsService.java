package com.example.springboot.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.springboot.user.model.Users;
import com.example.springboot.user.service.UserService;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserService userservice;
	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 예시: 하드코딩된 사용자 정보를 반환
    	Users findUsers = null;
    	
		try {
			findUsers = userservice.findUserByUserId(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        if (findUsers != null) {
        	return User.withUsername(findUsers.getUserId())
                    .password(findUsers.getPassword())
                    .roles(findUsers.getAuthority())
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    	
    }
}