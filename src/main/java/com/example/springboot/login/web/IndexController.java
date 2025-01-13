package com.example.springboot.login.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;

/**
 * Controller for "/".
 *
 * @author Rob WInch
 */
@Controller
public class IndexController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/movie")  
	public String list() { 	
			
		return "/pages/list";
	}
}