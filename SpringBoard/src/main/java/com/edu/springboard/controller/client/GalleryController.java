package com.edu.springboard.controller.client;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edu.springboard.domain.Gallery;
import com.edu.springboard.exception.GalleryException;
import com.edu.springboard.exception.PhotoException;
import com.edu.springboard.exception.UploadException;
import com.edu.springboard.model.gallery.GalleryService;

@Controller
public class GalleryController {
	private Logger log = LoggerFactory.getLogger(this.getClass().getName());
	@Autowired
	private GalleryService galleryService;
	
	@GetMapping("/gallery/registform")
	public ModelAndView getRegistForm() {
		log.info("=======등록 폼 요청=======");
		
		log.info("=======등록 폼 반환=======");
		return new ModelAndView("gallery/registform");
	}
	
	@ExceptionHandler(GalleryException.class)
	public ModelAndView handle(GalleryException e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("e", e);
		mav.setViewName("error/result");
		
		return mav;
	}
	
	@ExceptionHandler(UploadException.class)
	public ModelAndView handle(UploadException e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("e", e);
		mav.setViewName("error/result");
		
		return mav;
	}
	@ExceptionHandler(PhotoException.class)
	public ModelAndView handle(PhotoException e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("e", e);
		mav.setViewName("error/result");
		
		return mav;
	}
}
