package com.example.springboot.login.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springboot.common.dao.UserMapper;
import com.example.springboot.common.dto.Users;

import lombok.RequiredArgsConstructor;

@Service
//@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

//	private final UserMapper userMapper;
//	private final BCryptPasswordEncoder encoder;
	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 예시: 하드코딩된 사용자 정보를 반환
        if ("user".equals(username)) {
        	return User.withUsername("user")
                    .password("{noop}1") // {noop}은 비밀번호를 암호화하지 않음을 의미
                    .roles("USER")
                    .build();
        	
//        	return new User(username, "{noop}1", AuthorityUtils.createAuthorityList("ROLE_USER"));
        } else if ("admin".equals(username)) {
        	return User.withUsername("admin")
                    .password("{noop}1") // {noop}은 비밀번호를 암호화하지 않음을 의미
                    .roles("ADMIN")
                    .build();
        	
//        	return new User(username, "{noop}1", AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    	
//    	Users user = new Users();
//    	user.setUserId(username);
//    	user = userMapper.findUser(user);
//    	
//    	if(user != null){
//    		List<GrantedAuthority> authorities = new ArrayList<>();
//    		return new User(user.getUserId(), user.getPassword(), authorities);
//    	}
//    	
//    	return null;
    }
    
//    @Transactional
//    public boolean join(String userId, String userPwd) {
//    	Users checkUser = new Users();
//    	checkUser.setUserId(userId);
//    	
//    	if(userMapper.findUser(checkUser) != null) {
//    		return false;
//    	}
//    	Users newUser = new Users();
//    	newUser.setUserId(userId);
//    	newUser.setPassword(encoder.encode(userPwd));
//    	userMapper.save(newUser);
//    	return true;
//    }
}