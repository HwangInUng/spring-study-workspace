package com.edu.springmvc2.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.edu.springmvc2.model.BoardService;

import lombok.Setter;

@Setter
public class ListController implements Controller {
	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	private BoardService boardService;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info("테스트");

		List list = (List) boardService.selectAll();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", list);
		mav.setViewName("admin-board/list");
		
		return mav;
	}
}
