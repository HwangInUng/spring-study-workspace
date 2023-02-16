package com.edu.springboard.model.gallery;

import java.util.List;

import com.edu.springboard.domain.Photo;

public interface PhotoDAO {
	public List selectAll();
	public List selectById(int photo_idx);
	public void insert(Photo photo);
	public void delete(int gallery_idx);
}
