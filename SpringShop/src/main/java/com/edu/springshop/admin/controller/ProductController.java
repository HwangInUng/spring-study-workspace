package com.edu.springshop.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edu.springshop.domain.Product;
import com.edu.springshop.model.category.CategoryService;
import com.edu.springshop.model.product.ProductService;

//상품과 관련된 요청을 처리하는 하위 컨트롤러 
@Controller
@RequestMapping("/product")
public class ProductController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	
	@GetMapping("/registform")
	public ModelAndView getForm(HttpServletRequest request) {
		
		List categoryList = categoryService.selectAll();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("categoryList", categoryList);
		mav.setViewName("admin/product/regist");
		
		return mav;
	}
	
	@GetMapping("/list")
	public ModelAndView getList(HttpServletRequest request) {
		log.debug("======상품 리스트 요청======");
		List<Product> productList = productService.selectAll();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("productList", productList);
		mav.setViewName("admin/product/list");
		
		log.debug("======상품 리스트 " + productList.size() + "건 반환======");
		return mav;
	}
	
	@GetMapping("/detail")
	public ModelAndView getDetail(int product_idx, HttpServletRequest request) {
		log.debug("======" + product_idx + "번 상품 요청======");
		List<Product> categoryList = categoryService.selectAll();
		Product product = productService.select(product_idx);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("categoryList", categoryList);
		mav.addObject("product", product);
		mav.setViewName("admin/product/detail");
		
		log.debug("======" + product_idx + "번 상품 반환======");
		return mav;
	}
}








