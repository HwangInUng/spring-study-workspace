package com.edu.springmvc2.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.edu.springmvc2.domain.Board;
import com.edu.springmvc2.exception.BoardException;

public class MybatisBoardDAO implements BoardDAO {
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List selectAll() {
		return sqlSession.selectList("Board.selectAll");
	}

	@Override
	public Board select(int board_idx) {
		return sqlSession.selectOne("Board.selectByPk", board_idx);
	}

	@Override
	public void insert(Board board) throws BoardException {
		int result = sqlSession.insert("Board.insert", board);
		if (result < 1) {
			throw new BoardException("등록 실패");
		}
	}

	@Override
	public void update(Board board) throws BoardException {
		int result = sqlSession.update("Board.update", board);
		if (result < 1) {
			throw new BoardException("수정 실패");
		}
	}

	@Override
	public void updateHit(int board_idx) throws BoardException {
		int result = sqlSession.update("Board.updateHit", board_idx);
		if (result < 1) {
			throw new BoardException("조회수 증가 오류");
		}
	}

	@Override
	public void delete(int board_idx) throws BoardException {
		int result = sqlSession.delete("Board.delete", board_idx);
		if (result < 1) {
			throw new BoardException("삭제 실패");
		}
	}
}
