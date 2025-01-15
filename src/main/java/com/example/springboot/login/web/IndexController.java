package com.example.springboot.login.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
	
	@GetMapping("admin/layoutStatic")
	public String layoutStatic() {
		return "admin/layoutStatic";
	}
	
	@GetMapping("user/layoutSidenavLight")
	public String layoutSidenavLight() {
		return "user/layoutSidenavLight";
	}
	
	@GetMapping("/register")
	public String register() {
		return "pages/register";
	}
	
	@GetMapping("/password")
	public String password() {
		return "pages/password";
	}
	
	@GetMapping("/401")
	public String error401() {
		return "pages/401";
	}
	
	@GetMapping("/404")
	public String error404() {
		return "pages/404";
	}
	
	@GetMapping("/500")
	public String error500() {
		return "pages/500";
	}
	
	@GetMapping("/charts")
	public String charts() {
		return "charts/charts";
	}
	
	@GetMapping("/tables")
	public String tables() {
		return "tables/tables";
	}
	
	public void getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userInfo = (UserDetails) authentication.getPrincipal();
        System.out.println("Logged-in user name: " + userInfo.getUsername());
        System.out.println("Logged-in user password: " + userInfo.getPassword());
        System.out.println("Logged-in user authorities: " + userInfo.getAuthorities());
        System.out.println("Logged-in authentication: " + authentication.toString());
    }
}