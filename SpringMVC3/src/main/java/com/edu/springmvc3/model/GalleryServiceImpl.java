package com.edu.springmvc3.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.springmvc3.domain.Gallery;
import com.edu.springmvc3.exception.GalleryException;
import com.edu.springmvc3.exception.UploadException;
import com.edu.springmvc3.model.util.FileManager;
import com.edu.springmvc3.mybatis.Mybatis;

import lombok.Setter;

@Service
public class GalleryServiceImpl implements GalleryService{
	@Autowired
	private Mybatis mybatis;
	@Autowired
	private GalleryDAO galleryDAO;
	@Autowired
	private FileManager fileManager;
	
	@Override
	public List selectAll() {
		SqlSession sqlSession = mybatis.getSqlSession();
		MybatisGalleryDAO dao = (MybatisGalleryDAO)galleryDAO;
		List list = dao.selectAll();
		
		mybatis.release(sqlSession);
		return list;
	}

	@Override
	public Gallery select(int gallery_idx) {

		return null;
	}

	@Override
	public void regist(Gallery gallery, String realPath) throws UploadException{
		SqlSession sqlSession = mybatis.getSqlSession();
		MybatisGalleryDAO dao = (MybatisGalleryDAO)galleryDAO;
		
		fileManager.save(gallery, realPath);
		dao.insert(gallery);
		sqlSession.commit();
		
		mybatis.release(sqlSession);
	}

	@Override
	public void update(Gallery gallery) throws GalleryException {

		
	}

	@Override
	public void delete(int gallery_idx) throws GalleryException {

		
	}
	
}
