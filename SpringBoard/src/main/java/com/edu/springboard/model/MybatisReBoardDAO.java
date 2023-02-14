package com.edu.springboard.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.springboard.domain.ReBoard;
import com.edu.springboard.exception.ReBoardException;

@Repository
public class MybatisReBoardDAO implements ReBoardDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List selectAll() {
		return sqlSessionTemplate.selectList("ReBoard.selectAll");
	}

	@Override
	public ReBoard selectById(int reboard_idx) {
		return sqlSessionTemplate.selectOne("ReBoard.selectById", reboard_idx);
	}

	@Override
	public void insert(ReBoard reBoard) throws ReBoardException {
		int result = sqlSessionTemplate.insert("ReBoard.insert", reBoard);
		if (result < 1) {
			throw new ReBoardException("등록 실패");
		}
	}

	@Override
	public void update(ReBoard reBoard) throws ReBoardException {
		int result = sqlSessionTemplate.update("ReBoard.update", reBoard);
		if (result < 1) {
			throw new ReBoardException("수정 실패");
		}
	}

	@Override
	public void updateHit(int reboard_idx) throws ReBoardException {
		int result = sqlSessionTemplate.update("ReBoard.updateHit", reboard_idx);
		if (result < 1) {
			throw new ReBoardException("조회수 증가 실패");
		}
	}

	@Override
	public void delete(int reboard_idx) throws ReBoardException {
		int result = sqlSessionTemplate.delete("ReBoard.delete", reboard_idx);
		if (result < 1) {
			throw new ReBoardException("등록 실패");
		}
	}

	@Override
	public void updateStep(ReBoard reBoard) {

	}

	@Override
	public void insertReply(ReBoard reBoard) throws ReBoardException {

	}

}
