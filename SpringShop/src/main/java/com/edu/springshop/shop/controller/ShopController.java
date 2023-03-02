package com.edu.springshop.shop.controller;

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

@Controller
@RequestMapping("/shop")
public class ShopController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ProductService productService;
	
	@GetMapping("/list")
	public ModelAndView getList(HttpServletRequest request) {
		log.debug("======상품 리스트 호출======");
		List productList = productService.selectAll();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("productList", productList);
		mav.setViewName("shop/shop");
		
		log.debug("======상품 "+ productList.size() + "건 호출======");
		return mav;
	}
	
	@GetMapping("detail")
	public ModelAndView getDetail(int product_idx, HttpServletRequest request) {
		log.debug("======"+ product_idx +"번 상품 호출======");
		Product product = productService.select(product_idx);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("product", product);
		mav.setViewName("shop/shop_detail");
		
		log.debug("======"+ product_idx +"번 상품 반환======");
		return mav;
	}
}
