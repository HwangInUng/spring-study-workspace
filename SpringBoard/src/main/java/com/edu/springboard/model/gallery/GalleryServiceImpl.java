package com.edu.springboard.model.gallery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.edu.springboard.domain.Gallery;
import com.edu.springboard.domain.Photo;
import com.edu.springboard.exception.GalleryException;
import com.edu.springboard.exception.PhotoException;
import com.edu.springboard.exception.UploadException;
import com.edu.springboard.model.util.FileManager;

@Service
public class GalleryServiceImpl implements GalleryService{
	@Autowired
	@Qualifier("jdbcGalleryDAO")
	private GalleryDAO galleryDAO;
	
	@Autowired
	@Qualifier("jdbcPhotoDAO")
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
	public void regist(Gallery gallery, String path) throws GalleryException, UploadException, PhotoException {
		//업로드된 사진 저장
		fileManager.save(gallery, path);
		
		//게시글 등록
		galleryDAO.insert(gallery);
		
		//save()에서 저장된 photo리스트의 사이즈만큼 반복문 수행
		List<Photo> list = gallery.getPhotoList();
		for(int i = 0; i < list.size(); i++) {
			//sava()에서 해당 파일을 저장하여 add한 내역이 포함
			Photo photo = list.get(i);
			photo.setGallery(gallery); //FK 획득을 위하여 세팅
			photoDAO.insert(photo);
		}
	}

	@Override
	public void update(Gallery gallery) throws GalleryException {
		
	}

	@Override
	public void delete(int gallery_idx) throws GalleryException {
		
	}

}
