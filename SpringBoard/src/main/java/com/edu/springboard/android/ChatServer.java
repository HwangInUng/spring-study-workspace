package com.edu.springboard.android;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ChatServer {
	private ServerSocket server;
	private Thread thread;

	public Vector<ChatThread> clientList = new Vector();

	public ChatServer() {
		thread = new Thread() {
			@Override
			public void run() {

				try {
					server = new ServerSocket(8000);
					System.out.println("서버 실행");

					while (true) {
						Socket socket = server.accept();
						System.out.println("접속자 발생");
						
						ChatThread thread = new ChatThread(socket, ChatServer.this);
						clientList.add(thread);
						System.out.println("현재 접속자 : " + clientList.size() + "명");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		thread.start();
	}

	public static void main(String[] args) {
		new ChatServer();
	}
}
