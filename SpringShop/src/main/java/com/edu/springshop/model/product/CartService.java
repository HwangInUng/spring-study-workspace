package com.edu.springshop.model.product;

import java.util.List;

import com.edu.springshop.domain.Cart;

public interface CartService {
	public List selectAll(Cart cart);
	public int selectCount(Cart cart);
	public void insert(Cart cart);
	public void update(Cart cart);
}
