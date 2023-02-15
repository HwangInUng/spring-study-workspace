package com.edu.springboard.model.gallery;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.edu.springboard.domain.Gallery;

@Repository
public class JdbcGalleryDAO implements GalleryDAO{

	@Override
	public List selectAll() {
		return null;
	}

	@Override
	public Gallery selectById(int gallery_idx) {
		return null;
	}

	@Override
	public void insert(Gallery gallery) {
		
	}

	@Override
	public void update(Gallery gallery) {
		
	}

	@Override
	public void delete(int gallery_idx) {
		
	}

}
