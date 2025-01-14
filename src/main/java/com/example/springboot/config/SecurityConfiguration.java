package com.example.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		// @formatter:off
		http	.csrf(AbstractHttpConfigurer::disable)
				.httpBasic(AbstractHttpConfigurer::disable)
//				.formLogin(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests((authorize) -> authorize
						.requestMatchers("/index").authenticated() // 로그인 후 /home 페이지 접근 허용
			            .requestMatchers("/", "/login", "/assets/**", "/css/**", "/images/**", "/js/**", "/vendor/**").permitAll() // 로그인 페이지는 누구나 접근 가능
//			            .requestMatchers("/admin").hasRole("ADMIN") // ADMIN 역할만 /admin 페이지 접근 가능
			            .requestMatchers("/**").hasRole("USER")
			            .anyRequest().authenticated()) // USER 역할만 /user 페이지 접근 가능
				// 폼 로그인은 현재 사용하지 않음         
				.formLogin(formLogin -> formLogin
						.loginPage("/login") // 로그인 페이지 URL
			            .loginProcessingUrl("/perform_login") // 로그인 폼 제출 URL
			            .defaultSuccessUrl("/index", true) // 로그인 성공 후 이동할 URL
			            .failureUrl("/login?error=true")) // 로그인 실패 시 이동할 URL
				.logout((logout) -> logout
						.logoutSuccessUrl("/login")
						.invalidateHttpSession(true))
				.sessionManagement(session -> session
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				);
		// @formatter:on
		return http.build();
	}

	// @formatter:off
//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails user = User.withDefaultPasswordEncoder()
//				.username("user")
//				.password("password")
//				.roles("USER")
//				.build();
//		return new InMemoryUserDetailsManager(user);
//	}
	// @formatter:on

	@Bean
	public static PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}