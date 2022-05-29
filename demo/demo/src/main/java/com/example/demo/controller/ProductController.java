package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.dto.ProductDto;
import com.example.demo.dto.ProductForm;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	public ProductRepository productRepository;
	
	@GetMapping
	public List<ProductDto> list(){
		var findAll = productRepository.findAll();
		return ProductDto.convert(findAll);
	
	}
	public ResponseEntity<ProductDto> create(ProductForm form, UriComponentsBuilder builder){
		Product convert = form.convert();
		Product product = productRepository.save(convert);
		URI uri = builder.path("/products/{id}").buildAndExpand(product.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProductDto(product));
			
	}
	
}
