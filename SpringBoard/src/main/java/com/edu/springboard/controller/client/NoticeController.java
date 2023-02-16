package com.edu.springboard.controller.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.springboard.domain.Notice;
import com.edu.springboard.model.notice.NoticeService;

@RestController
public class NoticeController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private NoticeService noticeService;
	
	@PostMapping("/rest/notice/regist")
	public String regist(Notice notice) {
		log.info(notice.getTitle());
		log.info(notice.getWriter());
		log.info(notice.getContent());
		
		return "post test";
	}
}
