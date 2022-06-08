package com.cotsoft.item.service;

import java.util.List;
import com.cotsoft.item.model.Item;

public interface ItemService {

	public List<Item> findAll();
	public Item findById(Long id, Integer cant);
}
