package com.edu.springboard.model.util;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.edu.springboard.domain.Gallery;

@Component
public class FileManager {
	public String createFileName(String filename) {
		long time = System.currentTimeMillis();
		String ext = filename.substring(filename.lastIndexOf("."));

		return time + ext;
	}

	public void save(Gallery gallery, String realPath) {
		MultipartFile[] multi = gallery.getPhoto();
		
		try {
			for (int i = 0; i < multi.length; i++) {
				String filename = multi[i].getOriginalFilename();
				multi[i].transferTo(new File(realPath + createFileName(filename)));
			}
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
	}
}
