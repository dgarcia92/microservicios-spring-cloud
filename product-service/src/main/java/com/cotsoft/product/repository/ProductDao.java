package com.cotsoft.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cotsoft.product.entity.Product;

public interface ProductDao extends JpaRepository<Product, Long> {

}
