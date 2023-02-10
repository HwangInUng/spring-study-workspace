package com.edu.springmvc3.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Gallery {
	private int gallery_idx;
	private String title;
	private String writer;
	private String content;
	private String regdate;
	private int hit;
	private String filename;
	
	//바이너리 파일을 받는 객체(해당 객체안에 보관)
	private MultipartFile file;
}
