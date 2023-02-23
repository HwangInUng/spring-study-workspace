package com.edu.springshop.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.edu.springshop.domain.Pimg;
import com.edu.springshop.domain.Product;
import com.edu.springshop.exception.UploadException;

@Component
public class FileManager {

	public String createFilename(String filename) {
		long time = System.currentTimeMillis();
		String ext = filename.substring(filename.lastIndexOf("."));

		return time + ext;
	}

	public void save(Product product, String savePath) throws UploadException {
		MultipartFile[] files = product.getPhoto(); //파일 추출
		
		List<Pimg> pimgList = new ArrayList(); //pimg 리스트 인스턴스 생성
		product.setPimgList(pimgList); //pimg 리스트 주입
		
		try {
			for (MultipartFile file : files) {
				Thread.sleep(10); //파일명 중복 방지
				Pimg pimg = new Pimg(); //empty pimg 객체 생성
				
				String filename = file.getOriginalFilename();
				filename = createFilename(filename);
				
				file.transferTo(new File(savePath + filename));
				pimg.setFilename(filename); //파일명 세팅
				
				pimgList.add(pimg); //파일명 세팅된 객체 저장
			}
		} catch (IllegalStateException | IOException | InterruptedException e) {
			e.printStackTrace();
			throw new UploadException("저장 실패", e);
		}
	}
}
