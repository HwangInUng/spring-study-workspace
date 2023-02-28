package com.edu.springshop.model.admin;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.springshop.domain.Admin;
import com.edu.springshop.exception.AdminException;

@Repository
public class MybatisAdminDAO implements AdminDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public Admin select(Admin admin) throws AdminException {
		Admin returnAdmin =  sqlSessionTemplate.selectOne("Admin.select", admin);
		if(returnAdmin == null) {
			throw new AdminException("일치하는 정보가 없습니다.");
		}
		return returnAdmin;
	}
	
	@Override
	public void insert(Admin admin) throws AdminException {
		int result = sqlSessionTemplate.insert("Admin.insert", admin);
		if(result < 1) {
			throw new AdminException("등록 실패");
		}
	}
}
