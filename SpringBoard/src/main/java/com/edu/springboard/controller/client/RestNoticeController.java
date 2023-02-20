package com.edu.springboard.controller.client;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.springboard.domain.Notice;
import com.edu.springboard.model.notice.NoticeService;

@RestController
@RequestMapping("/rest")
public class RestNoticeController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private NoticeService noticeService;
	
	//RESTFul하게 컨트롤러 작성
	@GetMapping("/notices")
	public List<Notice> getList() {
		return noticeService.selectAll();
	}
	
	//{}는 파라미터로 넘어올 데이터를 구분
	@GetMapping("/notices/{notice_idx}")
	public Notice detail(@PathVariable("notice_idx") int notice_idx) {
		return noticeService.detail(notice_idx);
	}
	
	@PostMapping("/notices")
	public String regist(Notice notice) {
		noticeService.regist(notice);
		
		return "등록 성공";
	}
	
	@DeleteMapping("/notices/{notice_idx}")
	public String delete(@PathVariable("notice_idx") int notice_idx) {
		noticeService.delete(notice_idx);
		
		return "삭제 성공";
	}
	
	@PutMapping("/notices")
	public String update(Notice notice) {
		noticeService.update(notice);
		
		return "수정 성공";
	}
	
}
