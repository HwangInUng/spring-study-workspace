package com.edu.springmvc2.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.edu.springmvc2.domain.Board;

public class JdbcBoardDAO implements BoardDAO {
	SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Board select(int board_idx) {
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
