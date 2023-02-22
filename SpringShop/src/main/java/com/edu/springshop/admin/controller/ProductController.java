package com.edu.springshop.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edu.springshop.model.category.CategoryService;

//상품과 관련된 요청을 처리하는 하위 컨트롤러 
@Controller
public class ProductController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/product/registform")
	public ModelAndView getForm() {
		
		List categoryList = categoryService.selectAll();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("categoryList", categoryList);
		mav.setViewName("admin/product/regist");
		
		return mav;
	}
}








