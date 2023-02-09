package com.edu.springmvc2.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.edu.springmvc2.domain.Board;
import com.edu.springmvc2.model.BoardService;

import lombok.Setter;

@Setter
public class ListController implements Controller {
	Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	private BoardService boardService;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("목록호출 요청");

		List boardList = boardService.selectAll();

		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList);
		mav.setViewName("board/list");

		logger.info("목록호출 성공");
		return mav;
	}
}
