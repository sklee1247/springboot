package com.example.springboot.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.user.model.Users;
import com.example.springboot.user.service.UserService;

@RestController
@RequestMapping("/register")
public class UserController {

	@Autowired
	UserService userservice;
	
	@PostMapping("/submitUser")
    public Map<String, String> submitUser(@RequestBody Users user) {
		Map<String, String> response = new HashMap<>();
		
		// 예: 데이터 저장 로직 수행
        System.out.println("Received user: " + user);
        
        try {
        	
        	Users findUsers = userservice.findUser(user);
        	
        	if(findUsers != null) {
        		response.put("message", "User " + user.getUserId() + " is Exits! Can not Created!");
        	} else {
        		 // BCryptPasswordEncoder 생성
                PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        		
                String encodedPassword = passwordEncoder.encode(user.getPassword());
                
                user.setPassword(encodedPassword);
                
        		userservice.userSave(user);
        		
        		response.put("message", "User " + user.getUserId() + " has been successfully submitted!");
        	}

        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        // 응답 데이터
        return response;
    }
}
