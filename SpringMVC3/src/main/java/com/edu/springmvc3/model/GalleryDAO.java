package com.edu.springmvc3.model;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.edu.springmvc3.domain.Gallery;

public interface GalleryDAO {
	public List selectAll();

	public Gallery select(int gallery_idx);

	public void insert(Gallery gallery);

	public void update(Gallery gallery);

	public void updateHit(int gallery_idx);

	public void delete(int gallery_idx);
}
