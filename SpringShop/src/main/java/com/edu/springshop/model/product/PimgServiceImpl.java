package com.edu.springshop.model.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.edu.springshop.domain.Product;
import com.edu.springshop.exception.PimgException;

@Service
public class PimgServiceImpl implements PimgService{
	@Autowired
	@Qualifier("mybatisPimgDAO")
	private PimgDAO pimgDAO;

	@Override
	public List selectAll() {
		return pimgDAO.selectAll();
	}

	@Override
	public List selectByProduct(int product_idx) {
		return pimgDAO.selectByProduct(product_idx);
	}

	@Override
	public void regist(Product product) throws PimgException {
		
	}

	@Override
	public void delete(int product_idx) throws PimgException {
	}

}
