package com.edu.springmvc3.model;

import java.util.List;

import com.edu.springmvc3.domain.Gallery;

public interface GalleryService {
	public List selectAll();
	public Gallery select(int gallery_idx);
	public void regist(Gallery gallery, String realPath);
	public void update(Gallery gallery);
	public void delete(int gallery_idx);
}
