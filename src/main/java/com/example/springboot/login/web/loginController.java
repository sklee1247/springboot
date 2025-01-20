/**
 * 
 */
package com.example.springboot.login.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 */
@Controller
@RequestMapping("/login")
public class loginController {
	
	@GetMapping("/login")
	public String login() {
		return "login/login";
	}
}
