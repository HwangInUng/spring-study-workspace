package com.edu.springboard.model;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.edu.springboard.domain.ReBoard;

@Repository
public class JdbcReBoardDAO implements ReBoardDAO {

	@Override
	public List selectAll() {
		return null;
	}

	@Override
	public ReBoard selectById(int reboard_idx) {
		return null;
	}

	@Override
	public void insert(ReBoard reBoard) {

	}

	@Override
	public void update(ReBoard reBoard) {

	}

	@Override
	public void updateHit(int reboard_idx) {

	}

	@Override
	public void delete(int reboard_idx) {

	}

	@Override
	public void updateStep(ReBoard reBoard) {

	}

	@Override
	public void insertReply(ReBoard reBoard) {

	}

}
