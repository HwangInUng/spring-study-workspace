package com.edu.springshop.admin.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edu.springshop.domain.Product;
import com.edu.springshop.exception.PimgException;
import com.edu.springshop.exception.ProductException;
import com.edu.springshop.exception.UploadException;
import com.edu.springshop.model.product.ProductService;
import com.edu.springshop.util.Message;

//상품과 관련된 요청을 처리하는 하위 컨트롤러 

@RestController
@RequestMapping("/rest")
public class RestProductController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductService productService;
	
	/*----------------------------------------상품 등록*/
	@RequestMapping(value="/product", method=RequestMethod.POST)
	public ResponseEntity<Message> regist(Product product, HttpServletRequest request) {
		log.debug("======등록 요청======");
		//저장경로 추출
		HttpSession session = request.getSession();
		ServletContext context = session.getServletContext();
		String savePath = context.getRealPath("/resources/data/");
		
		productService.regist(product, savePath);
		log.debug("저장 경로 : " + savePath);
		
		Message message = new Message();
		message.setMsg("등록 성공");
		
		ResponseEntity<Message> entity = new ResponseEntity<Message>(message, HttpStatus.OK);
		
		log.debug("======등록 성공======");
		return entity;
	}
	
	/*----------------------------------------Product Exception*/
	@ExceptionHandler(ProductException.class)
	public ResponseEntity<Message> handle(ProductException e){
		Message message = new Message();
		message.setMsg(e.getMessage());
		
		ResponseEntity<Message> entity = new ResponseEntity<Message>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	}
	
	/*----------------------------------------Pimg Exception*/
	@ExceptionHandler(PimgException.class)
	public ResponseEntity<Message> handle(PimgException e){
		Message message = new Message();
		message.setMsg(e.getMessage());
		
		ResponseEntity<Message> entity = new ResponseEntity<Message>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	}
	
	/*----------------------------------------Upload Exception*/
	@ExceptionHandler(UploadException.class)
	public ResponseEntity<Message> handle(UploadException e){
		Message message = new Message();
		message.setMsg(e.getMessage());
		
		ResponseEntity<Message> entity = new ResponseEntity<Message>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	}
	
}
