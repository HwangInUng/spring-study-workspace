package com.edu.springdb.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.edu.springdb.domain.Board;
import com.edu.springdb.exception.BoardException;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	@Qualifier("mybatisBoardDAO")
	private BoardDAO boardDAO;

	@Override
	public List selectAll() {
		return boardDAO.selectAll();
	}

	@Override
	public Board detail(int board_idx) throws BoardException {
		boardDAO.updateHit(board_idx);
		return boardDAO.selectById(board_idx);
	}

	@Override
	public void regist(Board board) throws BoardException {
		boardDAO.insert(board);
	}

	@Override
	public void update(Board board) throws BoardException {
		boardDAO.update(board);
	}

	@Override
	public void delete(int board_idx) throws BoardException {
		boardDAO.delete(board_idx);
	}

}
