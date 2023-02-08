package com.edu.springmvc.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardException extends RuntimeException{
	public BoardException(String msg) {
		super(msg);
	}
	public BoardException(String msg, Throwable e) {
		super(msg, e);
	}
}
