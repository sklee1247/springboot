package com.example.springboot.login.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class UserRoleCheck {
	
	public void checkUserRole() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Object principal = authentication.getPrincipal();
		UserDetails user = null;
		
		if (principal instanceof UserDetails) {
		    user = (UserDetails) principal;
		}
        
        // 사용자 권한 확인
        if (user.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER"))) {
            System.out.println("사용자는 USER 역할을 가지고 있습니다.");
        }
        
        if (user.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            System.out.println("사용자는 ADMIN 역할을 가지고 있습니다.");
        }
    }
}
