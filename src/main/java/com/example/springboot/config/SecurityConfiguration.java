package com.example.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration{

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http	.csrf(AbstractHttpConfigurer::disable)
				.httpBasic(AbstractHttpConfigurer::disable)
//				.formLogin(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests((authorize) -> authorize
						.requestMatchers("/index").authenticated() // 로그인 후 /home 페이지 접근 허용
		                .requestMatchers("/", "/login/login", "/register/**", "/assets/**", "/css/**", "/images/**", "/js/**", "/vendor/**").permitAll() // 로그인 페이지는 누구나 접근 가능
			            .requestMatchers("/admin/**").hasRole("ADMIN") // ADMIN 역할만 /admin 페이지 접근 가능
			            .requestMatchers("/user/**").hasRole("USER") // USER 역할만 /user 페이지 접근 가능
			            .anyRequest().authenticated())
				// 폼 로그인은 현재 사용하지 않음         
				.formLogin(formLogin -> formLogin
//						.successHandler(new CustomAuthenticationSuccessHandler())
//						.failureHandler(new CustomAuthenticationFailureHandler())
						.loginPage("/login/login") // 로그인 페이지 URL
			            .loginProcessingUrl("/perform_login")
			            .permitAll() // 로그인 폼 제출 URL
			            .defaultSuccessUrl("/index", true) // 로그인 성공 후 이동할 URL
			            .failureUrl("/login/login?error=true"))
				// 로그인 실패 시 이동할 URL
				.logout((logout) -> logout
						.logoutSuccessUrl("/login/login")
						.invalidateHttpSession(true))
				.sessionManagement(session -> session
					.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
				);
		
		return http.build();
	}

	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // BCrypt를 사용하여 비밀번호 암호화
    }
	
	@Bean
	public HttpSessionEventPublisher httpSessionEventPublisher() {
	    return new HttpSessionEventPublisher();
	}
}