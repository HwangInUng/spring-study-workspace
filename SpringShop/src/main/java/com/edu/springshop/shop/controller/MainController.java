package com.edu.springshop.shop.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edu.springshop.model.category.CategoryService;

@Controller
public class MainController {
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/")
	public ModelAndView getMain(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("shop/index");
		
		return mav;
	}
}
