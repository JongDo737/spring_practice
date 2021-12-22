package com.spring.study.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.study.domain.user.User;
import com.spring.study.service.auth.AuthService;
import com.spring.study.web.dto.auth.SigninReqDto;
import com.spring.study.web.dto.auth.SigninRespDto;
import com.spring.study.web.dto.auth.SignupReqDto;
import com.spring.study.web.dto.auth.SignupRespDto;

@Controller
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(Model model, SignupReqDto signupReqDto) {
		if(signupReqDto.getSubmitFlag() == 1) {
			// 아이디 중복확인.(select)
			SignupRespDto signupRespDto = authService.usernameCheck(signupReqDto);
			
			model.addAttribute("signupRespDto", signupRespDto);
			
			return "auth/signup";
			
		}else {
			// 회원가입 진행(insert)
			boolean signupSuccessFlag = authService.signup(signupReqDto);
			if(signupSuccessFlag == true) {
				return "redirect:/signin";
			}else {
				return "auth/signup";
			}
			
		}
		
	}
	
	@RequestMapping(value ="/signin", method = RequestMethod.POST)
	public String signin(Model model, HttpServletRequest request, SigninReqDto signinReqDto) {
		SigninRespDto signinRespDto = authService.signin(signinReqDto);
		if(signinRespDto.getSigninFlag() == 2) { //세션
			//로그인 성공했을 때
			HttpSession session = request.getSession(); //세션을 들고옴 이미 로그인 성공한 상태니까 리스폰스껄 사용
			User loginUser = authService.getUserByusername(signinRespDto.getUsername()); 
			//				서비스 연결.메서드사용			메개변수 (username)
			session.setAttribute("principal", loginUser);
			return "redirect:/index";
		}
		
		
		model.addAttribute("signinRespDto",signinRespDto);
		
		return "auth/signin"; // 로그인 성공했을 때
	}
	@ResponseBody	//이 어노테이션을 달아주면 리턴값으로 주소를 보내는게 아니라 진짜 string 값을 리턴함
	@RequestMapping(value="/signup/username-check", method = RequestMethod.GET)
	public Object signupAjax(SignupReqDto signupReqDto) {
		SignupRespDto signupRespDto = authService.usernameCheck(signupReqDto);
		return signupRespDto; //반환값 object에 이렇게 하면 json 형태로 보내짐
	}
	@ResponseBody
	@RequestMapping(value = "/signin/ajax", method = RequestMethod.POST)
	public Object signinAjax(@RequestBody SigninReqDto signinReqDto, HttpServletRequest request) {
		SigninRespDto signinRespDto = authService.signin(signinReqDto);
		if(signinRespDto.getSigninFlag() ==2) {
			HttpSession session = request.getSession();
			User loginUser = authService.getUserByusername(signinRespDto.getUsername());
			session.setAttribute("principal", loginUser);
		}
		return null;
	}
	
}
