package com.example.demo.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.demo.model.Product;

public class ProductForm {

	private String description;
	private String name;
	private Double price;
	
	public String getDescription() {
		return description;
	}


	public String getName() {
		return name;
	}


	public Double getPrice() {
		return price;
	}


	public Product convert() {
		Product product = new Product();
		product.setName(name);
		product.setDescription(description);
		product.setPrice(price);
		return product;
		
	}

	
}
