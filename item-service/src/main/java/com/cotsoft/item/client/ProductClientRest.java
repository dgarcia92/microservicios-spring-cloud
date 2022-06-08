package com.cotsoft.item.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cotsoft.item.model.Product;

//antes de Ribbon
//@FeignClient(name = "product-service", url = "http://localhost:8001/api/product")

/*Ribbon se configurá en application properties*/
@FeignClient(name = "product-service")
public interface ProductClientRest {

	@GetMapping    //Se debe de llamar igual que el EdPoint del Controlador del Micro al que queremos llamar
	public List<Product> listAll();
	
	@GetMapping("/{id}")
	public Product detail(@PathVariable Long id);
}
