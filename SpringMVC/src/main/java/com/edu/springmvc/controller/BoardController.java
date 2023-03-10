package com.edu.springmvc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.edu.springmvc.model.BoardService;

import lombok.Setter;

@Controller
@Setter
public class BoardController {
	Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	//매핑된 객체를 자동으로 주입
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board")
	public String getList(Model model) {
		logger.info("게시판 목록 처리");
		List boardList = boardService.selectAll();
		
		model.addAttribute("boardList", boardList);
		
		return "board/list";
	}
}
