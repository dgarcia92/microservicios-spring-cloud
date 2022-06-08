package com.cotsoft.item.model;

public class Item {

	private Product product;
	private Integer cant;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getCant() {
		return cant;
	}
	public void setCant(Integer cant) {
		this.cant = cant;
	}
	
	public Item() {
		
	}
	public Item(Product product, Integer cant) {
		this.product = product;
		this.cant = cant;
	}
	
	/*Metodo para calcular el importe */
	public Double getTotal()
	{
		return product.getPrice() * cant.doubleValue();
	}
	
}
