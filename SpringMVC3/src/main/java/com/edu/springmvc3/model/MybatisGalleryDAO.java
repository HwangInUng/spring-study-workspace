package com.edu.springmvc3.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.edu.springmvc3.domain.Gallery;
import com.edu.springmvc3.exception.GalleryException;

import lombok.Setter;

@Setter
@Repository
public class MybatisGalleryDAO implements GalleryDAO {
	private SqlSession sqlSession;

	@Override
	public List selectAll() {
		return sqlSession.selectList("Gallery.selectAll");
	}

	@Override
	public Gallery select(int gallery_idx) {
		return sqlSession.selectOne("Gallery.selectByPk", gallery_idx);
	}

	@Override
	public void insert(Gallery gallery) throws GalleryException {
		int result = sqlSession.insert("Gallery.insert", gallery);
		if (result < 1) {
			throw new GalleryException("등록 실패");
		}
	}

	@Override
	public void update(Gallery gallery) throws GalleryException {
		int result = sqlSession.update("Gallery.update", gallery);
		if (result < 1) {
			throw new GalleryException("수정 실패");
		}
	}

	@Override
	public void updateHit(int gallery_idx) throws GalleryException {
		int result = sqlSession.update("Gallery.updateHit", gallery_idx);
		if (result < 1) {
			throw new GalleryException("조회수 오류");
		}
	}

	@Override
	public void delete(int gallery_idx) throws GalleryException {
		int result = sqlSession.delete("Gallery.delete", gallery_idx);
		if (result < 1) {
			throw new GalleryException("삭제 실패");
		}
	}
}
