package com.edu.springshop.model.product;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.springshop.domain.Product;
import com.edu.springshop.exception.ProductException;

@Repository
public class MybatisProductDAO implements ProductDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List selectAll() {
		return sqlSessionTemplate.selectList("Product.selectAll");
	}

	@Override
	public Product select(int product_idx) {
		return sqlSessionTemplate.selectOne("Product.select", product_idx);
	}

	@Override
	public void insert(Product product) throws ProductException {
		int result = sqlSessionTemplate.insert("Product.insert", product);
		if(result < 1) {
			throw new ProductException("등록 성공");
		}
	}

	@Override
	public void update(Product product) throws ProductException {
		int result = sqlSessionTemplate.update("Product.update", product);
		if(result < 1) {
			throw new ProductException("수정 성공");
		}
	}

	@Override
	public void delete(int product_idx) throws ProductException {
		int result = sqlSessionTemplate.delete("Product.delete", product_idx);
		if(result < 1) {
			throw new ProductException("삭제 성공");
		}
	}
	
}