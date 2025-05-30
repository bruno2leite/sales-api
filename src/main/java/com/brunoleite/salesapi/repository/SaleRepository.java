package com.brunoleite.salesapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.brunoleite.salesapi.model.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

	List<Sale> findByCustomerId(Long customerId);

}
