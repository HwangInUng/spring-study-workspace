package com.edu.springboard.model.gallery;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.springboard.domain.Gallery;
import com.edu.springboard.exception.GalleryException;

@Repository
public class MybatisGalleryDAO implements GalleryDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List selectAll() {
		return sqlSessionTemplate.selectList("Gallery.selectAll");
	}

	@Override
	public Gallery selectById(int gallery_idx) {
		return sqlSessionTemplate.selectOne("Gallery.selectById", gallery_idx);
	}

	@Override
	public void insert(Gallery gallery) throws GalleryException {
		int result = sqlSessionTemplate.insert("Gallery.insert", gallery);
		if(result < 1) {
			throw new GalleryException("등록 실패");
		}
	}

	@Override
	public void update(Gallery gallery) throws GalleryException {
		int result = sqlSessionTemplate.update("Gallery.update", gallery);
		if(result < 1) {
			throw new GalleryException("수정 실패");
		}
	}

	@Override
	public void delete(int gallery_idx) throws GalleryException {
		int result = sqlSessionTemplate.update("Gallery.delete", gallery_idx);
		if(result < 1) {
			throw new GalleryException("삭제 실패");
		}
	}

}
