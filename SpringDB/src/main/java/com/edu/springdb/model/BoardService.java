package com.edu.springdb.model;

import java.util.List;

import com.edu.springdb.domain.Board;

public interface BoardService {
	public List selectAll();
	public Board detail(int board_idx);
	public void regist(Board board);
	public void update(Board board);
	public void delete(int board_idx);
}
