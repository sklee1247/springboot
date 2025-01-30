/**
 * 
 */
package com.example.springboot.login.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

/**
 * 
 */
@Controller
@RequestMapping("/login")
public class loginController {
	
	@GetMapping("/login")
	public String login(HttpSession session) {
		
		return "login/login";
	}
}
