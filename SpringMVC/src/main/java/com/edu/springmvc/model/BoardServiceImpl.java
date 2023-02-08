package com.edu.springmvc.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.springmvc.domain.Board;
import com.edu.springmvc.mybatis.Mybatis;

import lombok.Setter;

@Service
@Setter
public class BoardServiceImpl implements BoardService{
	Mybatis mybatis = Mybatis.getInstance();
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public void regist(Board board) {
		
	}
	@Override
	public void delete(Board board) {
		
	}
	@Override
	public void select(int board_idx) {
		
	}
	@Override
	public List selectAll() {
		SqlSession sqlSession = mybatis.getSqlSession();
		boardDAO.setSession(sqlSession);
		
		List list = boardDAO.selectAll();
		
		mybatis.release(sqlSession);
		return list;
	}
}
