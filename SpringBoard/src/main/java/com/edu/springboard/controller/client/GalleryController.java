package com.edu.springboard.controller.client;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.edu.springboard.domain.Gallery;
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
	
	@GetMapping("/gallery/regist")
	public ModelAndView regist(Gallery gallery, HttpServletRequest request) {
		ServletContext context = request.getSession().getServletContext();
		String realPath = (String)context.getAttribute("dataPath");
		
		galleryService.regist(gallery, realPath);
		
		
		return null;
	}
}
