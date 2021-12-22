package com.spring.study.service.auth;

import com.spring.study.domain.user.User;
import com.spring.study.web.dto.auth.SigninReqDto;
import com.spring.study.web.dto.auth.SigninRespDto;
import com.spring.study.web.dto.auth.SignupReqDto;
import com.spring.study.web.dto.auth.SignupRespDto;

public interface AuthService {
	
	//signup
	public SignupRespDto usernameCheck(SignupReqDto signupReqDto);
	public boolean signup(SignupReqDto signupReqDto);
	
	//signin
	public SigninRespDto signin(SigninReqDto signinReqDto);
	
	public User getUserByusername(String username);
	
}
