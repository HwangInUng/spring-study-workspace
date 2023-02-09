package com.edu.springmvc2.controller;

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
public class RegistController implements Controller {
	Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	private BoardService boardService;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("게시물 등록요청");

		Board board = new Board();
		board.setTitle(request.getParameter("title"));
		board.setWriter(request.getParameter("writer"));
		board.setContent(request.getParameter("content"));

		boardService.insert(board);

		ModelAndView mav = new ModelAndView();
		// 응답이 완료되고 재요청
		mav.setViewName("redirect:/board/list");

		logger.info("게시물 등록성공");
		return mav;
	}
}
