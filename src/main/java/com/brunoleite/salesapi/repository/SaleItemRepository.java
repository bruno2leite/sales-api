package com.brunoleite.salesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.brunoleite.salesapi.model.SaleItem;

public interface SaleItemRepository extends JpaRepository<SaleItem, Long>{

}
