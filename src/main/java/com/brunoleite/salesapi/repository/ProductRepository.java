package com.brunoleite.salesapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brunoleite.salesapi.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	Optional<Product> findByName(String name);
}
