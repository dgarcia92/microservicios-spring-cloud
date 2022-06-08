package com.cotsoft.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cotsoft.product.entity.Product;
import com.cotsoft.product.repository.ProductDao;

@Service
public class ProductServiceImp implements IProductService {

	@Autowired
	private ProductDao repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Product> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Product findById(Long id) {
		return repository.findById(id).orElse(null);
	}

}
