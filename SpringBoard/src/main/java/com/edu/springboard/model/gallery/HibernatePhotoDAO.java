package com.edu.springboard.model.gallery;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.springboard.domain.Photo;

@Repository
public class HibernatePhotoDAO implements PhotoDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List selectAll() {
		return null;
	}

	@Override
	public List selectById(int gallery_idx) {
		return null;
	}

	@Override
	public void insert(Photo photo) {
		
	}

	@Override
	public void delete(int photo_idx) {
		// TODO Auto-generated method stub
		
	}
}
