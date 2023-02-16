package com.edu.springboard.android;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpClient {
	public static void main(String[] args) {
		DataOutputStream dataOutputStream = null;
		BufferedReader br = null;
		try {
			//요청을 보낼 URL 작성
			URL url = new URL("http://172.30.1.78:7777/rest/notice/regist");
			String param = "title=test&writer=tester&content=contentTest";
			
			//HttpURLConnection : 자바에서 웹 서버와의 요청 및 응답정보를 받기 위한 전용객체
			HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
			//전송 방식 설정
			httpCon.setRequestMethod("POST");
			
			httpCon.setDoOutput(true);
			httpCon.setUseCaches(false);
			
			//콘텐트 타입 설정
			httpCon.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			
			//출력 스트림 이용 전송
			dataOutputStream = new DataOutputStream(httpCon.getOutputStream());
			dataOutputStream.writeBytes(param); //POSt 전송
			
			//응답 정보 받기
			br = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
			String msg = null;
			
			while(true) {
				msg = br.readLine();
				if(msg == null) break;
				System.out.println(msg);
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(dataOutputStream != null) {
				try {
					dataOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
