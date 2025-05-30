package com.brunoleite.salesapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.brunoleite.salesapi.model.Product;
import com.brunoleite.salesapi.repository.ProductRepository;

@Service
public class ProductService {
	private ProductRepository productRepository;
	
	public ProductService (ProductRepository productRepository) {
		this.productRepository = productRepository;
	
	}
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public Product createProduct(Product product) {
		Optional<Product> existingProduct = productRepository.findByName(product.getName());
		
		if (existingProduct.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product Already Exists");
		}
		
		return productRepository.save(product);
	}
}
