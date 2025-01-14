package com.example.springboot.login.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for "/".
 *
 * @author Rob WInch
 */
@Controller
public class IndexController {

	@GetMapping("/")
	public String root() {
		return "login/login";
	}
	
	@GetMapping("/index")
	public String index() {
		getCurrentUser();
		
//		UserRoleCheck urc = new UserRoleCheck();
//		urc.checkUserRole();
		
		return "index";
	}
	
	public void getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = (String) authentication.getPrincipal();
        System.out.println("Logged-in user: " + username);
        System.out.println("Logged-in authentication: " + authentication.toString());
    }
}