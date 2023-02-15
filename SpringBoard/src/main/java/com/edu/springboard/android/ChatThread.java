package com.edu.springboard.android;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ChatThread implements Runnable{
	private Thread thread;
	private Socket socket;
	
	//입출력 객체 보유
	private BufferedReader br;
	private BufferedWriter bw;
	
	//서버의 리스트를 호출하기 위하여 멤버로 보유
	private ChatServer chatServer;
	
	public ChatThread(Socket socket, ChatServer chatServer) {
		thread = new Thread(this);
		this.socket = socket;
		this.chatServer = chatServer;
		
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		thread.start();
	}
	
	public void listen() {
		String msg = null;
		
		try {
			msg = br.readLine(); //청취된 메세지를 읽어드림
			
			//서버가 보유한 스레드의 리스트만큼보유한 메서드를 실행
			for(int i = 0; i < chatServer.clientList.size(); i++) {
				ChatThread ct = chatServer.clientList.get(i);
				ct.send(msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void send(String msg) {
		try {
			//전달받은 메세지를 출력하여 전송
			bw.write(msg + "\n");
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(true) {
			listen();
		}
	}
}
