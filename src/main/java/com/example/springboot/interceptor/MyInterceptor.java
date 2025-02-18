package com.example.springboot.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    
    // Called before the controller method is executed
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Before controller method execution");
        
        System.out.println("request.getRequestURI() ==> " + request.getRequestURI());
        
        if (request.getRequestURI().equals("/perform_login") && request.getMethod().equalsIgnoreCase("POST")) {
            System.out.println("로그인 요청 감지: " + request.getRemoteAddr());
            // 로그인 전 처리 (예: 로그인 시도 기록, IP 제한 등)
        } else {
            // Check if the session contains the user attribute (i.e., the user is logged in)
            Object user = request.getSession().getAttribute("user");
            
            if (user == null) {
                // If not logged in, redirect to the login page
                response.sendRedirect("/login");
                return false; // Prevent further processing of the request
            }
            
            // Optionally check session expiration (custom logic)
            if (isSessionExpired(request)) {
                response.sendRedirect("/sessionExpired"); // Custom session expired page
                return false;
            }
        }

        return true; // Return true to proceed to the controller, false to stop the request
    }

    // Called after the controller method has executed but before the view is rendered
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("After controller method execution");
    }

    // Called after the complete request has finished
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("After view rendering is complete");
    }
    
    private boolean isSessionExpired(HttpServletRequest request) {
        // Logic to check if the session has expired based on custom conditions
        return false;
    }
}