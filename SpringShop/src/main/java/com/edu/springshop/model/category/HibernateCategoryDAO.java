package com.edu.springshop.model.category;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.springshop.domain.Category;
import com.edu.springshop.exception.CategoryException;

@Repository
public class HibernateCategoryDAO implements CategoryDAO {
	@Override
	public List selectAll() {
		return null;
	}

	@Override
	public Category select(int category_idx) {
		return null;
	}

	@Override
	public void insert(Category category) throws CategoryException {
	}

	@Override
	public void update(Category category) throws CategoryException {
	}

	@Override
	public void delete(int category_idx) throws CategoryException {
	}

}