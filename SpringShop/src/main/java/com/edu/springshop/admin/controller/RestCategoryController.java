package com.edu.springshop.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.springshop.domain.Category;
import com.edu.springshop.exception.CategoryException;
import com.edu.springshop.model.category.CategoryService;
import com.edu.springshop.util.Message;

@RestController
@RequestMapping("/rest/category")
public class RestCategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping
	public Message regist(Category category) {
		
		categoryService.regist(category);
		
		Message message = new Message();
		message.setMsg("등록 성공");
		
		return message;
	}
	
	@GetMapping
	public List<Category> getList(){
		return categoryService.selectAll();
	}
	
	@ExceptionHandler(CategoryException.class)
	public ResponseEntity<Message> handle(CategoryException e) {
		//ResponseEntity : Http 응답정보를 보다 세밀하고 구성하기 위해
		Message message = new Message();
		
		ResponseEntity<Message> entity = new ResponseEntity<Message>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		message.setMsg(e.getMessage());
		
		return entity;
	}
}