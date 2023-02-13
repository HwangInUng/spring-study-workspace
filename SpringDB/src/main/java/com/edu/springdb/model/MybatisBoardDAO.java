package com.edu.springdb.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.springdb.domain.Board;
import com.edu.springdb.exception.BoardException;

@Repository
public class MybatisBoardDAO implements BoardDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List selectAll() {
		return sqlSessionTemplate.selectList("Board.selectAll");
	}

	@Override
	public Board selectById(int board_idx) {
		return sqlSessionTemplate.selectOne("Board.selectById", board_idx);
	}

	@Override
	public void insert(Board board) throws BoardException {
		int result = sqlSessionTemplate.insert("Board.insert", board);
		if(result < 1) {
			throw new BoardException("등록 실패");
		}
	}

	@Override
	public void update(Board board) throws BoardException {
		int result = sqlSessionTemplate.update("Board.update", board);
		if(result < 1) {
			throw new BoardException("수정 실패");
		}
	}

	@Override
	public void updateHit(int board_idx) throws BoardException {
		int result = sqlSessionTemplate.update("Board.updateHit", board_idx);
		if(result < 1) {
			throw new BoardException("조회수 증가 오류");
		}
	}

	@Override
	public void delete(int board_idx) throws BoardException {
		int result = sqlSessionTemplate.delete("Board.delete", board_idx);
		if(result < 1) {
			throw new BoardException("삭제 실패");
		}
	}
}
