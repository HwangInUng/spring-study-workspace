package com.edu.springshop.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.springshop.domain.Category;
import com.edu.springshop.exception.CategoryException;
import com.edu.springshop.model.category.CategoryService;
import com.edu.springshop.util.Message;

@RestController
@RequestMapping("/rest/category")
public class RestCategoryController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CategoryService categoryService;

	@PostMapping
	public Message regist(Category category) { // 등록요청

		categoryService.regist(category);

		Message message = new Message();
		message.setMsg("등록 성공");

		return message;
	}

	@GetMapping
	public List<Category> getList() { // 목록요청
		return categoryService.selectAll();
	}

	@PutMapping
	public ResponseEntity<Message> update(@RequestBody Category category) { // 수정요청
		log.debug("======수정 요청======");

		categoryService.update(category);

		Message message = new Message();
		message.setMsg("수정 성공");
		ResponseEntity<Message> entity = new ResponseEntity<Message>(message, HttpStatus.OK);

		log.debug("======수정 완료======");
		return entity;
	}

	@DeleteMapping("/{category_idx}")
	public ResponseEntity<Message> delete(@PathVariable int category_idx) {
		log.debug("======삭제 요청======");

		categoryService.delete(category_idx);

		Message message = new Message();
		message.setMsg("삭제 성공");
		ResponseEntity<Message> entity = new ResponseEntity<Message>(message, HttpStatus.OK);

		log.debug("======삭제 완료======");
		return entity;
	}

	@ExceptionHandler(CategoryException.class)
	public ResponseEntity<Message> handle(CategoryException e) {
		// ResponseEntity : Http 응답정보를 보다 세밀하고 구성하기 위해
		Message message = new Message();

		ResponseEntity<Message> entity = new ResponseEntity<Message>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		message.setMsg(e.getMessage());

		return entity;
	}
}
