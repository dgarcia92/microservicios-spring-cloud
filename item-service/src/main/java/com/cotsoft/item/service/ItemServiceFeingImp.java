package com.cotsoft.item.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.cotsoft.item.client.ProductClientRest;
import com.cotsoft.item.model.Item;

@Service("serviceFeing")
public class ItemServiceFeingImp implements ItemService{

	@Autowired
	private ProductClientRest client;
	
	@Override
	public List<Item> findAll() {
		return client.listAll().stream().map( p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cant) {
		return new Item(client.detail(id), cant);
	}

}
