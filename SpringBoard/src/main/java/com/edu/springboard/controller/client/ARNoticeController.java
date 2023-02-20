package com.edu.springboard.controller.client;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.springboard.domain.Notice;
import com.edu.springboard.exception.NoticeException;
import com.edu.springboard.model.notice.NoticeService;

@RestController
@RequestMapping("/rest/notice")
public class ARNoticeController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private NoticeService noticeService;
	
	@PostMapping("/regist")
	public String regist(Notice notice) {
		log.info(notice.getTitle());
		log.info(notice.getWriter());
		log.info(notice.getContent());
		
		noticeService.regist(notice);
		
		return "등록 성공";
	}
	
	@GetMapping("/list")
	public List getList() {
		return noticeService.selectAll();
	}
	
	@GetMapping("/detail")
	public Notice getDetail(int notice_idx) {
		return noticeService.detail(notice_idx);
	}
	
	@PostMapping("/update")
	public String update(Notice notice) {
		noticeService.update(notice);
		
		return "수정 완료";
	}
	
	@GetMapping("/delete")
	public String delete(int notice_idx) {
		noticeService.delete(notice_idx);
		
		return "삭제 완료";
	}
	
	@ExceptionHandler(NoticeException.class)
	public String handle(NoticeException e) {
		return e.getMessage();
	}
}
