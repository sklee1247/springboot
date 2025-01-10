package com.example.springboot.login.web;

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
	public String index() {
		return "index";
	}

}