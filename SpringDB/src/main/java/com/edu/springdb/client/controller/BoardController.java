package com.edu.springdb.client.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edu.springdb.domain.Board;
import com.edu.springdb.exception.BoardException;
import com.edu.springdb.model.BoardService;

@Controller
public class BoardController {
	private Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "/board/registform")
	public String getRegistForm() {
		log.info("------등록폼 요청-------");
		return "board/registform";
	}
	
	@RequestMapping(value = "/board/regist")
	public ModelAndView regist(Board board) {
		log.info("------글쓰기 요청-------");
		
		boardService.regist(board);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/board/list");
		
		log.info("------글쓰기 성공-------");
		return mav;
	}
	
	@RequestMapping(value = "/board/list")
	public ModelAndView getList() {
		log.info("------목록 요청-------");
		List boardList = boardService.selectAll();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList);
		mav.setViewName("board/list");
		
		log.info("------목록 반환-------");
		return mav;
	}
	
	@RequestMapping(value = "/board/detail")
	public ModelAndView getDetail(int board_idx) {
		log.info("------상세보기 요청-------");
		
		Board board = boardService.detail(board_idx);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board);
		mav.setViewName("board/detail");
		
		log.info("------상세보기 반환-------");
		return mav;
	}
	
	@RequestMapping(value = "board/update")
	public ModelAndView update(Board board) {
		log.info("------업데이트 요청-------");
		
		boardService.update(board);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/board/detail?board_idx=" + board.getBoard_idx());
		
		log.info("------업데이트 반환-------");
		return mav;
	}
	
	@RequestMapping(value = "board/delete")
	public ModelAndView delete(int board_idx) {
		log.info("------삭제 요청-------");
		
		boardService.delete(board_idx);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/board/list");
		
		log.info("------삭제 완료-------");
		return mav;
	}
	
	@ExceptionHandler(BoardException.class)
	public ModelAndView handle(BoardException e) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("e", e);
		mav.setViewName("error/result");
		
		return mav;
	}
}
