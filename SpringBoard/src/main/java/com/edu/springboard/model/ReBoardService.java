package com.edu.springboard.model;

import java.util.List;

import com.edu.springboard.domain.ReBoard;

public interface ReBoardService {
	public List selectAll();
	public ReBoard detail(int reboard_idx);
	public void insert(ReBoard reBoard);
	public void registReply(ReBoard reBoard);
	public void update(ReBoard reBoard);
	public void delete(int reboard_idx);
}
