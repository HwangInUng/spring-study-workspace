package com.edu.springshop.aop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.edu.springshop.exception.EmailException;
import com.edu.springshop.exception.HashException;
import com.edu.springshop.exception.MemberException;
import com.edu.springshop.util.Message;

//예외를 하나의 클래스에서 처리
@RestControllerAdvice(annotations = RestController.class)
public class RestGlobalException {
	@ExceptionHandler(value= {MemberException.class, EmailException.class, HashException.class})
	public ResponseEntity<Message> handle(RuntimeException e){
		
		Message message = new Message();
		message.setMsg(e.getMessage());
		
		ResponseEntity<Message> entity = new ResponseEntity<Message>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	}
}