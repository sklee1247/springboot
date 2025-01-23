package com.example.springboot.user.model;

import java.time.LocalDate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Users {

	private String userId;

	private String email;
	
	private String password;

	private String authority;

	private LocalDate createdAt;
}