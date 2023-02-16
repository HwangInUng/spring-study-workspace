package com.edu.springboard.model.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.edu.springboard.domain.Gallery;
import com.edu.springboard.domain.Photo;
import com.edu.springboard.exception.UploadException;

@Component
public class FileManager {
	public String createFileName(String filename) {
		long time = System.currentTimeMillis();
		String ext = filename.substring(filename.lastIndexOf("."));

		return time + ext;
	}

	public void save(Gallery gallery, String realPath) throws UploadException{
		MultipartFile[] multi = gallery.getPhoto();
		
		//저장될 이미지명을 담을 리스트 생성
		List<Photo> photoList = new ArrayList(); 
		gallery.setPhotoList(photoList);
		
		try {
			for (int i = 0; i < multi.length; i++) {
				//파일이 동일한 이름으로 저장되는 것을 방지
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				String filename = createFileName(multi[i].getOriginalFilename());
				multi[i].transferTo(new File(realPath + filename));
				
				//새로 저장될 이미지명을 파일 리스트 내 각각의 객체에 세팅
				Photo photo = new Photo();
				photo.setFilename(filename);
				photoList.add(photo);
			}
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			throw new UploadException("파일 저장 실패", e);
		}
	}
}
