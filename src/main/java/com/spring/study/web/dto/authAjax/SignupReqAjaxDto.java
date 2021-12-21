package com.spring.study.web.dto.authAjax;

import com.spring.study.domain.user.User;

import lombok.Data;

@Data
public class SignupReqAjaxDto {
	private String username;
	private String password;
	private String name;
	private String email;
	
	public User toEntity() {
		return User.builder()
				.username(username)
				.password(password)
				.name(name)
				.email(email)
				.build();
	}
}






