package com.edu.springmvc2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class RegistFormController implements Controller {
	Logger log = LoggerFactory.getLogger(this.getClass().getName());

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info("등록폼 요청");

		String viewName = request.getRequestURI();

		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);

		log.info("등록폼 출력 성공");
		return mav;
	}
}
