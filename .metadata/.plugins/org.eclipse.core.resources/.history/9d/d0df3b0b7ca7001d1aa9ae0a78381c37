package com.mvc.model.emp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mvc.domain.Emp;
import com.mvc.exception.DeptException;
import com.mvc.exception.EmpException;
import com.mvc.mybatis.Mybatis;

/*
 * 모델 계층에서의 서비스 역할을 수행
 * 서비스 부재 시 컨트롤러가 모델 계층의 일부 로직을 수행
 * 또한, 트랜잭션 상황에서 성공 여부 판단 등의 업무를 수행하기가 제한됨
 * */
public class EmpService {
	Mybatis mybatis = Mybatis.getInstance();
	DeptDAO deptDAO;
	EmpDAO empDAO;
	
	public EmpService() {
		deptDAO = new DeptDAO();
		empDAO = new EmpDAO();
	}
	
	public void empRegist(Emp emp) {
		//SqlSession injection
		SqlSession sqlSession = mybatis.getSqlSession();
		deptDAO.setSqlSession(sqlSession);
		empDAO.setSqlSession(sqlSession);
		
		try {
			deptDAO.insert(emp.getDept());
			empDAO.insert(emp);
			
			sqlSession.commit();
		} catch (DeptException e) { //dept 등록 실패 시
			e.getMessage();
			sqlSession.rollback();
		} catch (EmpException e) { //emp 등록 실패 시
			e.getMessage();
			sqlSession.rollback();
		} finally {
			mybatis.release(sqlSession);
		}
	}
	
	public List<Emp> selectAll(){
		SqlSession sqlSession = mybatis.getSqlSession();
		empDAO.setSqlSession(sqlSession);
		List<Emp> list = empDAO.selectAll();
		
		mybatis.release(sqlSession);
		
		return list;
	}
	
	public void delete(int empno) {
		SqlSession sqlSession = mybatis.getSqlSession();
		deptDAO.setSqlSession(sqlSession);
		empDAO.setSqlSession(sqlSession);
		
		//매개변수를 전달받아 emp 레코드 반환
		Emp emp = empDAO.select(empno);
		try {
			empDAO.delete(emp.getEmpno());
			deptDAO.delete(emp.getDept().getDeptno());
			
			sqlSession.commit();
		} catch (EmpException e) {
			sqlSession.rollback();
		} catch (DeptException e) {
			sqlSession.rollback();
		} finally {
			mybatis.release(sqlSession);
		}
	}
}
