package com.cotsoft.product.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cotsoft.product.entity.Product;
import com.cotsoft.product.service.IProductService;

@RestController
public class ProductController {

	@Autowired
	private Environment env;
	
	@Value("${server.port}")
	private Integer port;
	
	@Autowired
	private IProductService service;
	
	@GetMapping("/")
	public List<Product> findAll(){
		return service.findAll().stream().map( prod -> {
			prod.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			return prod;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	public Product findByID(@PathVariable("id") Long id) {
		
		Product producto = service.findById(id);
		producto.setPort( port );
		
		return service.findById(id);
	}
	
	
	
}
