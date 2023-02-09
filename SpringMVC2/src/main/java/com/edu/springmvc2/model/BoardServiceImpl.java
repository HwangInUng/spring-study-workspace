package com.edu.springmvc2.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.edu.springmvc2.domain.Board;
import com.edu.springmvc2.exception.BoardException;
import com.edu.springmvc2.mybatis.Mybatis;

import lombok.Setter;

@Setter
public class BoardServiceImpl implements BoardService {
	private Mybatis mybatis;
	private BoardDAO boardDAO;

	@Override
	public List selectAll() {
		SqlSession sqlSession = mybatis.getSqlSession();
		MybatisBoardDAO dao = (MybatisBoardDAO) boardDAO;
		dao.setSqlSession(sqlSession);

		List list = dao.selectAll();
		mybatis.release(sqlSession);

		return list;
	}

	@Override
	public Board select(int board_idx) {
		SqlSession sqlSession = mybatis.getSqlSession();
		MybatisBoardDAO dao = (MybatisBoardDAO) boardDAO;
		dao.setSqlSession(sqlSession);

		Board board = dao.select(board_idx);
		if (board != null) { // 조회수 증가
			dao.updateHit(board_idx);
			sqlSession.commit();
		}
		mybatis.release(sqlSession);

		return board;
	}

	@Override
	public void insert(Board board) throws BoardException {
		SqlSession sqlSession = mybatis.getSqlSession();
		MybatisBoardDAO dao = (MybatisBoardDAO) boardDAO;
		dao.setSqlSession(sqlSession);

		dao.insert(board);
		sqlSession.commit();
		mybatis.release(sqlSession);
	}

	@Override
	public void update(Board board) throws BoardException {
		SqlSession sqlSession = mybatis.getSqlSession();
		MybatisBoardDAO dao = (MybatisBoardDAO) boardDAO;
		dao.setSqlSession(sqlSession);

		dao.update(board);
		sqlSession.commit();
		mybatis.release(sqlSession);
	}

	@Override
	public void delete(int board_idx) throws BoardException {
		SqlSession sqlSession = mybatis.getSqlSession();
		MybatisBoardDAO dao = (MybatisBoardDAO) boardDAO;
		dao.setSqlSession(sqlSession);

		dao.delete(board_idx);
		sqlSession.commit();
		mybatis.release(sqlSession);
	}

}
