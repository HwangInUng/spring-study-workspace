package com.edu.springshop.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.springshop.domain.Admin;
import com.edu.springshop.exception.AdminException;
import com.edu.springshop.model.admin.AdminService;
import com.edu.springshop.util.Message;

@RestController
@RequestMapping("/rest")
public class RestAdminController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private AdminService adminService;

	@PostMapping("/login-admin")
	public ResponseEntity<Message> loginCheck(Admin admin, HttpServletRequest request) {
		log.debug("====== 로그인 접근 ======");
		HttpSession session = request.getSession();
		Admin returnAdmin = adminService.select(admin);
		
		//로그인 정보 저장
		session.setAttribute("admin", returnAdmin);
		
		Message message = new Message();
		message.setMsg("로그인 성공");
		
		ResponseEntity<Message> entity = new ResponseEntity<Message>(message, HttpStatus.OK);
		
		log.debug("====== 로그인 승인 ======");
		return entity;
	}
}
