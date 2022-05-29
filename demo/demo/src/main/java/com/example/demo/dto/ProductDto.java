package com.example.demo.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.model.Product;

public class ProductDto {

	
	private Long id;
	private String description;
	private String name;
	private Double price;


	public ProductDto(Product product ) {
		this.id = product.getId();
		this.description = product.getDescription();
		this.name = product.getName();
		this.price = product.getPrice();
	}

	
	public Long getId() {
		return id;
	}


	public String getDescription() {
		return description;
	}


	public String getName() {
		return name;
	}


	public Double getPrice() {
		return price;
	}

	public static  List<ProductDto> convert(List<Product> products){
		return products.stream().map(x -> new ProductDto(x)).collect(Collectors.toList());
	}
	
}
