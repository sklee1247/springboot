package com.example.springboot.login.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 예시: 하드코딩된 사용자 정보를 반환
        if ("user".equals(username)) {
//        	return User.withUsername("user")
//                    .password("{noop}1") // {noop}은 비밀번호를 암호화하지 않음을 의미
//                    .roles("USER")
//                    .build();
        	
        	return new User(username, "{noop}1", AuthorityUtils.createAuthorityList("ROLE_USER"));
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}