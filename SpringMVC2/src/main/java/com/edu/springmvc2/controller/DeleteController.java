package com.edu.springmvc2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.edu.springmvc2.model.BoardService;

import lombok.Setter;

@Setter
public class DeleteController implements Controller {
	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	private BoardService boardService;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info("삭제 요청");

		String board_idx = request.getParameter("board_idx");
		boardService.delete(Integer.parseInt(board_idx));

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/board/list");

		log.info("삭제 성공");
		return mav;
	}
}
