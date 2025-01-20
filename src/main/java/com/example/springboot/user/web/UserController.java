package com.example.springboot.user.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.user.dto.Users;

@RestController
@RequestMapping("/user")
public class UserController {

	@PostMapping("/userRegist")
    public Map<String, String> submitUser(@RequestBody Users user) {
        // 예: 데이터 저장 로직 수행
        System.out.println("Received user: " + user);

        // 응답 데이터
        Map<String, String> response = new HashMap<>();
        response.put("message", "User " + user.getUserId() + " has been successfully submitted!");
        return response;
    }
}
