package com.edu.springdb.model;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.edu.springdb.domain.Board;

@Repository
public class HinernateBoardDAO implements BoardDAO{

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Board selectById(int board_idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Board board) {
		// TODO Auto-generated method stub
	}

	@Override
	public void update(Board board) {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateHit(int board_idx) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(int board_idx) {
		// TODO Auto-generated method stub
	}
	
}
