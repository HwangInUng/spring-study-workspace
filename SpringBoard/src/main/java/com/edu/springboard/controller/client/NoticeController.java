package com.edu.springboard.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edu.springboard.domain.Notice;
import com.edu.springboard.model.notice.NoticeService;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("/notice/list")
	public ModelAndView goList() {
		return new ModelAndView("notice/list");
	}
	
	@GetMapping("/notice/registform")
	public ModelAndView getRegistForm() {
		return new ModelAndView("notice/registform");
	}
	
	@GetMapping("notice/detail")
	public ModelAndView getDetail(int notice_idx) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("notice_idx", notice_idx);
		mav.setViewName("notice/detail");
		
		return mav;
	}
}
