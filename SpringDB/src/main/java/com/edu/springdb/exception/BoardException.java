package com.edu.springdb.exception;

public class BoardException extends RuntimeException{
	public BoardException(String msg) {
		super(msg);
	}
	public BoardException(String msg, Throwable e) {
		super(msg, e);
	}
}
