package com.edu.springmvc3.model.util;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.edu.springmvc3.domain.Gallery;
import com.edu.springmvc3.exception.UploadException;

@Component
public class FileManager {

	public String createFileName(String fileName) {
		long time = System.currentTimeMillis();
		String ext = fileName.substring(fileName.lastIndexOf("."));

		return time + ext;
	}

	public void save(Gallery gallery, String realPath) throws UploadException {
		MultipartFile file = gallery.getFile();

		String filename = createFileName(file.getOriginalFilename());
		try {
			file.transferTo(new File(realPath + filename));
			gallery.setFilename(filename);
		} catch (IllegalStateException | IOException e) {
			throw new UploadException("파일 저장 실패", e);
		}
	}
}
