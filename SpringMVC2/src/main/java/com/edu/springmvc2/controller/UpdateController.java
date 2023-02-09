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
public class UpdateController implements Controller {
	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	private BoardService boardService;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info("게시물 수정 요청");

		Board board = new Board();
		board.setTitle(request.getParameter("title"));
		board.setWriter(request.getParameter("writer"));
		board.setContent(request.getParameter("content"));
		board.setBoard_idx(Integer.parseInt(request.getParameter("board_idx")));

		boardService.update(board);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/board/detail?board_idx=" + board.getBoard_idx());

		log.info("게시물 수정 성공");
		return mav;
	}
}
