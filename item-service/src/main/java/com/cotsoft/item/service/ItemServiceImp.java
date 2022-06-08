package com.cotsoft.item.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cotsoft.item.model.Item;
import com.cotsoft.item.model.Product;

@Service("serviceRestTemplate")
public class ItemServiceImp implements ItemService {

	@Autowired
	private RestTemplate restClient;
	
	@Override
	public List<Item> findAll() {
		List<Product> products = Arrays.asList(restClient.getForObject("http://product-service", Product[].class));
		return products.stream().map( product -> new Item(product, 1)).collect(Collectors.toList());
	}
	
	@Override
	public Item findById(Long id, Integer cant) {
		
		Map<String, String> pathVariables = new HashMap<>();
		pathVariables.put("id", id.toString());
		
		Product product = restClient.getForObject("http://product-service/{id}", Product.class, pathVariables);
		return new Item(product, cant);
	}

}
