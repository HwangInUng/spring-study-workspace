package com.edu.springshop.model.category;

import java.util.List;

import com.edu.springshop.domain.Category;

public interface CategoryService {
	public List selectAll();
	public Category detail(int category_idx);
	public void regist(Category category);
	public void update(Category category);
	public void delete(int category_idx);
}
