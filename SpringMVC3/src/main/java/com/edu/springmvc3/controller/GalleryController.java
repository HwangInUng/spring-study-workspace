package com.edu.springmvc3.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edu.springmvc3.domain.Gallery;
import com.edu.springmvc3.exception.UploadException;
import com.edu.springmvc3.model.GalleryService;
import com.edu.springmvc3.model.util.FileManager;

//핸들러 매핑이 어노테이션을 기반으로 컴포넌트 형태를 식별
@Controller
public class GalleryController {
	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	@Autowired
	private GalleryService galleryService;

	@RequestMapping(value = "/client/gallery/list")
	public String getList() {
		log.info("매핑테스트");

		return "gallery/list";
	}

	@RequestMapping(value = "/client/gallery/registform")
	public String getRegistForm() {
		log.info("등록폼 요청");

		return "gallery/registform";
	}

	@RequestMapping(value = "/client/gallery/regist")
	public String regist(Gallery gallery, HttpServletRequest request) {
		ServletContext context = request.getSession().getServletContext();
		String realPath = (String)context.getAttribute("dataPath");
		
		galleryService.regist(gallery, realPath);
		
		return "redirect:/client/gallery/list";
	}
	//현재 컨트롤러의 모든 요청처리 메서드에서 예외 발생 시
	//아래의 핸들러가 동작하게되어있음
	//()안에 지정한 예외클래스에 맞는 메서드만 호출
	@ExceptionHandler(UploadException.class)
	public ModelAndView handle(UploadException e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("e", e);
		mav.setViewName("error/result");
		return mav;
	}
}
