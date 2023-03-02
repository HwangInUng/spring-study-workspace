package com.edu.springshop.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.edu.springshop.exception.AdminException;
import com.edu.springshop.util.Message;

@RestControllerAdvice(annotations = RestController.class)
public class RestAdminGlobalException {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@ExceptionHandler(value= AdminException.class)
	public ResponseEntity<Message> handle(AdminException e){
		log.debug("Rest Global Exception 실행");
		
		Message message = new Message();
		message.setMsg(e.getMessage());
		
		ResponseEntity<Message> entity = new ResponseEntity<Message>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	}
}
