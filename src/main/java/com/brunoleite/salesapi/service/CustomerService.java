package com.brunoleite.salesapi.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.brunoleite.salesapi.model.Customer;
import com.brunoleite.salesapi.repository.CustomerRepository;

@Service
public class CustomerService {
	private final CustomerRepository customerRepository;
	
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	public Customer createCustomer(Customer customer) {
		customer.setCreatedAt(LocalDate.now());
		return customerRepository.save(customer);
	}
	
	public List<Customer> findAll(){
		return customerRepository.findAll();
	}
	
	

}
