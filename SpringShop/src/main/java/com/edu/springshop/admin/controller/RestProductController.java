package com.edu.springshop.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edu.springshop.domain.Product;
import com.edu.springshop.util.Message;

//상품과 관련된 요청을 처리하는 하위 컨트롤러 

@RestController
@RequestMapping("/rest")
public class RestProductController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value="/product", method=RequestMethod.POST)
	public Message regist(Product product) {
		
		log.info("넘어온 상태 " + product);
		
		return null;
	}
}
