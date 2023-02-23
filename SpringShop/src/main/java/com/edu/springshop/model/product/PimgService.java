package com.edu.springshop.model.product;

import java.util.List;

import com.edu.springshop.domain.Product;

public interface PimgService {
	public List selectAll();
	public List selectByProduct(int product_idx);
	public void regist(Product product);
	public void delete(int product_idx);
}
