package com.mvc.model.emp;

import org.apache.ibatis.session.SqlSession;

import com.mvc.domain.Dept;
import com.mvc.exception.DeptException;

public class DeptDAO {
	SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public void delete(int deptno) throws DeptException{
		int result = sqlSession.delete("Dept.delete", deptno);
		if(result < 1) {
			throw new DeptException("부서삭제 실패");
		}
	}
	
	public void insert(Dept dept) throws DeptException{
		int result = sqlSession.insert("Dept.insert", dept);
		if(result < 1) {
			throw new DeptException("부서등록 실패");
		}
	}
}
