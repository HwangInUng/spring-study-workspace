package com.edu.springshop.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.edu.springshop.exception.AdminException;

@ControllerAdvice(annotations = Controller.class)
public class AdminGlobalException {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@ExceptionHandler(AdminException.class)
	public ModelAndView handle(AdminException e) {
		log.debug("Global Exception 실행");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("error", e);
		mav.setViewName("admin/error/result");
		
		return mav;
	}
}
