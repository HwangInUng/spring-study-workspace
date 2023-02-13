package com.edu.springdb.model;

import java.util.List;

import com.edu.springdb.domain.Board;

public interface BoardDAO {
	public List selectAll();
	public Board selectById(int board_idx);
	public void insert(Board board);
	public void update(Board board);
	public void updateHit(int board_idx);
	public void delete(int board_idx);
}
