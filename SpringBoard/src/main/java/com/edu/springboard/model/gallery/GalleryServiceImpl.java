package com.edu.springboard.model.gallery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.edu.springboard.domain.Gallery;
import com.edu.springboard.exception.GalleryException;
import com.edu.springboard.model.util.FileManager;

@Service
public class GalleryServiceImpl implements GalleryService{
	@Autowired
	@Qualifier("mybatisGalleryDAO")
	private GalleryDAO galleryDAO;
	
	@Autowired
	@Qualifier("mybatisPhotoDAO")
	private PhotoDAO photoDAO;
	@Autowired
	private FileManager fileManager;
	
	@Override
	public List selectAll() {
		return galleryDAO.selectAll();
	}

	@Override
	public Gallery detail(int gallery_idx) {
		return galleryDAO.selectById(gallery_idx);
	}

	@Override
	public void regist(Gallery gallery, String path) throws GalleryException {
		fileManager.save(gallery, path);
	}

	@Override
	public void update(Gallery gallery) throws GalleryException {
		
	}

	@Override
	public void delete(int gallery_idx) throws GalleryException {
		
	}

}
