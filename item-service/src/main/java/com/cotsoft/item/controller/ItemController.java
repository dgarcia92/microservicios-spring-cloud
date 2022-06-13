package com.cotsoft.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cotsoft.item.model.Item;
import com.cotsoft.item.model.Product;
import com.cotsoft.item.service.ItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping
public class ItemController {

	
	@Autowired
	@Qualifier("serviceFeing")
	//@Qualifier("serviceRestTemplate")
	private ItemService itemService;
	
	@GetMapping
	public List<Item> list()
	{
		return itemService.findAll();
	}
	
	@HystrixCommand(fallbackMethod = "metodoAlternativo")
	@GetMapping("/{id}/{cant}")
	public Item detail(@PathVariable("id") Long id, @PathVariable("cant") Integer cant)
	{
		return itemService.findById(id, cant);
	}
	
	
	public Item metodoAlternativo(Long id, Integer cant)
	{
		Item item = new Item();
		Product product = new Product();
		
		item.setCant(cant);
		product.setId(id);
		product.setName("Undefined");
		product.setPrice(0.0);
		item.setProduct(product);
		
		return item;
	}
	
	
}
