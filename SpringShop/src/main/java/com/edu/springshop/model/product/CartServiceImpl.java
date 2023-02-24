package com.edu.springshop.model.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.springshop.domain.Cart;

@Service
public class CartServiceImpl implements CartService{
	@Autowired
	private CartDAO cartDAO;
	
	@Override
	public List selectAll(Cart cart) {
		return null;
	}

	@Override
	public int selectCount(Cart cart) {
		return 0;
	}

	@Override
	public void insert(Cart cart) {
		
	}

	@Override
	public void update(Cart cart) {
		
	}
	
}
