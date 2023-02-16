package com.edu.springboard.controller.client;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.springboard.domain.Gallery;
import com.edu.springboard.exception.GalleryException;
import com.edu.springboard.exception.PhotoException;
import com.edu.springboard.exception.UploadException;
import com.edu.springboard.model.gallery.GalleryService;

//해당 어노테이션은 @ResponseBody를 생략가능
@RestController
public class RestGalleryController {
	private Logger log = LoggerFactory.getLogger(this.getClass().getName());
	@Autowired
	private GalleryService galleryService;
	
	@PostMapping("/gallery/regist")
	public String regist(Gallery gallery, HttpServletRequest request) {
		//request 객체로부터 servletcontext 객체를 얻어와 realpath를 획득
		ServletContext context = request.getSession().getServletContext();
		String realPath = context.getRealPath("/resources/data/");
		
		galleryService.regist(gallery, realPath);
		
		return "ok";
	}
	
	@GetMapping("/rest/gallery/list")
	public List<Gallery> getList() {
		
		List<Gallery> galleryList = galleryService.selectAll();
		
		return galleryList;
	}
	
	@GetMapping("/rest/gallery/detail")
	public Gallery getDetail(int gallery_idx) {
		
		Gallery gallery = galleryService.detail(gallery_idx);
		
		return gallery;
	}
	
	@ExceptionHandler(GalleryException.class)
	public String handle(GalleryException e) {
		
		return "에러";
	}
	
	@ExceptionHandler(UploadException.class)
	public String handle(UploadException e) {
		
		return "에러";
	}
	@ExceptionHandler(PhotoException.class)
	public String handle(PhotoException e) {
		
		return "에러";
	}
}

