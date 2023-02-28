package com.edu.springshop.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edu.springshop.exception.AdminException;

@Controller
public class AdminController {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/loginform")
	public ModelAndView getLoginForm(HttpServletRequest request) {
		logger.debug("======로그인 양식 호출======");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/login/loginform");
		
		logger.debug("======로그인 양식 반환======");
		return mav;
	}
	
	@GetMapping("/main")
	public ModelAndView getMain(HttpServletRequest request) { //매개변수가 존재해야 aop에서 사용가능
		logger.info("====== 관리자 메인 이동시도======");
		HttpSession session = request.getSession();
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("admin/index");

		logger.info("====== 관리자 메인 접속 ======");
		return mav;
	}
}




