package com.edu.springboard.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.edu.springboard.domain.ReBoard;
import com.edu.springboard.exception.ReBoardException;

@Service
public class ReBoardServletImpl implements ReBoardService {
	@Autowired
	@Qualifier("mybatisReBoardDAO")
	private ReBoardDAO reBoardDAO;

	@Override
	public List selectAll() {
		return reBoardDAO.selectAll();
	}

	@Override
	public ReBoard detail(int reboard_idx) throws ReBoardException {
		reBoardDAO.updateHit(reboard_idx);
		return reBoardDAO.selectById(reboard_idx);
	}

	@Override
	public void insert(ReBoard reBoard) throws ReBoardException {
		reBoardDAO.insert(reBoard);
	}

	@Override
	public void registReply(ReBoard reBoard) throws ReBoardException {
		reBoardDAO.updateStep(reBoard);
		reBoardDAO.insertReply(reBoard);
	}

	@Override
	public void update(ReBoard reBoard) throws ReBoardException {
		reBoardDAO.update(reBoard);
	}

	@Override
	public void delete(int reboard_idx) throws ReBoardException {
		reBoardDAO.delete(reboard_idx);
	}

}
