package com.edu.springmvc.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.edu.springmvc.domain.Board;
import com.edu.springmvc.exception.BoardException;

@Repository
public class BoardDAO {
	SqlSession session;

	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	public void insert(Board board) throws BoardException{
		int result = session.insert("Board.insert", board);
		if(result < 1) {
			throw new BoardException("등록 실패");
		}
	}
	
	public List<Board> selectAll() {
		return session.selectList("Board.selectAll");
	}
	
	public Board selectByIdx(int board_idx) {
		return session.selectOne("Board.select", board_idx);
	}
	
	public void update(Board board) throws BoardException{
		int result = session.update("Board.update", board);
		if(result < 1) {
			throw new BoardException("수정 실패");
		}
	}
	
	public void delete(int board_idx) throws BoardException{
		int result = session.delete("Board.delete", board_idx);
		if(result < 1) {
			throw new BoardException("삭제 실패");
		}
	}
}
