package com.brunoleite.salesapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunoleite.salesapi.dto.RestockDTO;
import com.brunoleite.salesapi.model.Product;
import com.brunoleite.salesapi.repository.ProductRepository;
import com.brunoleite.salesapi.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {
	private final ProductService productService;
	private final ProductRepository productRepository;
	
	public ProductController(ProductService productService, ProductRepository productRepository) {
		this.productService = productService;
		this.productRepository = productRepository;

	}
	
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		Product created = productService.createProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> products = productService.findAll();
		products = productRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
		return ResponseEntity.ok(products);
	}
	
	@PutMapping("/restock")
	public ResponseEntity<?> restockProduct(@RequestBody @Valid RestockDTO restock){
		Long id = restock.getId();
	    int quantity = restock.getQuantity();
		
	    Optional<Product> optionalProduct = productRepository.findById(id);
		
	    if(optionalProduct.isEmpty()) {
	    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product Not Found");
	    }
	    Product product = optionalProduct.get();
		product.setStock(product.getStock() + quantity);
		productRepository.save(product);
		
		return ResponseEntity.ok("Produto com ID " + id + " reabastecido com quantidade " + quantity);
	
	}
	
}
