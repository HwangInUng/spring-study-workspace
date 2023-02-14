package com.edu.springboard.controller.client;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edu.springboard.domain.ReBoard;
import com.edu.springboard.model.ReBoardDAO;
import com.edu.springboard.model.ReBoardService;

@Controller
public class ReBoardController {
	private Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	private ReBoardService reBoardService;
	
	@RequestMapping(value="/reboard/registform")
	public ModelAndView getRegistForm() {
		log.info("-------등록 폼 요청-------");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("reboard/registform");
		
		log.info("-------등록 폼 반환-------");
		return mav;
	}
	
	@RequestMapping(value="/reboard/list")
	public ModelAndView getList() {
		log.info("-------리스트 호출-------");
		
		List<ReBoard> reBoardList = reBoardService.selectAll();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("reBoardList", reBoardList);
		mav.setViewName("reboard/list");
		
		log.info("-------리스트 " + reBoardList.size() +"건 반환-------");
		return mav;
	}
	
	@RequestMapping(value = "/reboard/regist")
	public ModelAndView regist(ReBoard reBoard) {
		log.info("-------게시물 등록 요청-------");
		
		reBoardService.insert(reBoard);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/reboard/list");
		
		log.info("-------게시물 등록 처리-------");
		return mav;
	}
	
	@RequestMapping(value = "/reboard/detail")
	public ModelAndView getDetail(int reboard_idx) {
		log.info("-------게시물 목록 요청-------");
		
		ReBoard reBoard = reBoardService.detail(reboard_idx);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("reBoard", reBoard);
		mav.setViewName("reboard/detail");
		
		log.info("-------게시물 1건 반환-------");
		return mav;
	}
	
	@RequestMapping(value = "/reboard/update")
	public ModelAndView update(ReBoard reBoard) {
		log.info("-------수정 요청-------");
		
		reBoardService.update(reBoard);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/reboard/detail?reboard_idx=" + reBoard.getReboard_idx());
		
		log.info("-------수정 처리완료-------");
		return mav;
	}
	
	@RequestMapping(value = "/reboard/delete")
	public ModelAndView delete(int reboard_idx) {
		log.info("-------삭제 요청-------");
		
		reBoardService.delete(reboard_idx);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/reboard/list");
		
		log.info("-------삭제 처리완료-------");
		return mav;
	}
	
	@RequestMapping(value = "/reboard/reply")
	public ModelAndView registReply(ReBoard reBoard) {
		log.info("-------답변 등록요청-------");
		
		reBoardService.registReply(reBoard);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/reboard/detail?reboard_idx=" + reBoard.getReboard_idx());
		
		log.info("-------답변 등록완료-------");
		return mav;
	}
	
}
