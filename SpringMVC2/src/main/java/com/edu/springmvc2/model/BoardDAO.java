package com.edu.springmvc2.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.edu.springmvc2.domain.Board;

public interface BoardDAO {
	public List selectAll();

	public Board select(int board_idx);

	public void insert(Board board);

	public void update(Board board);

	public void updateHit(int board_idx);

	public void delete(int board_idx);
}
