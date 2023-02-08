package com.edu.springmvc.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {
	private int board_idx;
	private String title;
	private String writer;
	private String content;
	private String regdate;
	private int hit;
}
