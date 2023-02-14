package com.edu.springboard.model;

import java.util.List;

import com.edu.springboard.domain.ReBoard;

public interface ReBoardDAO {
	public List selectAll();
	public ReBoard selectById(int reboard_idx);
	public void insert(ReBoard reBoard);
	public void update(ReBoard reBoard);
	public void updateHit(int reboard_idx);
	public void delete(int reboard_idx);
	
	//답변관련
	public void updateStep(ReBoard reBoard);
	public void insertReply(ReBoard reBoard);
}
