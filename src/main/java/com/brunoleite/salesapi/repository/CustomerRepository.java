package com.brunoleite.salesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.brunoleite.salesapi.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
