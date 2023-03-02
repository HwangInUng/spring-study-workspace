package com.edu.springshop.shop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

//회원관 관련된 요청을 처리하는 하위 컨트롤러 
@Controller
public class MemberController {

	//회원가입 폼 요청처리
	@GetMapping("/member/joinform")
	public ModelAndView getJoinForm(HttpServletRequest request) {
		
		return new ModelAndView("shop/member/joinform");
	}
	
	//회원가입 양식 요청
	@GetMapping("/member/login")
	public ModelAndView getLoginForm(HttpServletRequest request) {
		return new ModelAndView("member/loginform");
	}
}