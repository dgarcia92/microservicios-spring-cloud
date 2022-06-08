package com.cotsoft.product.service;

import java.util.List;
import java.util.Optional;

import com.cotsoft.product.entity.Product;

public interface IProductService {

	public List<Product> findAll();
	public Product findById(Long id);
}
