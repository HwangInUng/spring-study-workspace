package com.edu.springmvc.model;

import java.util.List;

import com.edu.springmvc.domain.Board;

public interface BoardService {
	public void regist(Board board);
	public List selectAll();
	public void select(int board_idx);
	public void delete(Board board);
}
