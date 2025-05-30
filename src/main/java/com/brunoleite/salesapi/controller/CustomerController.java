package com.brunoleite.salesapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunoleite.salesapi.dto.CustomerDTO;
import com.brunoleite.salesapi.model.Customer;
import com.brunoleite.salesapi.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	private final CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@PostMapping
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
		Customer savedCustomer = customerService.createCustomer(customer);
		return ResponseEntity.ok(savedCustomer);
	}
	
	@GetMapping
	public ResponseEntity<List<CustomerDTO>> getAllCustomers(){
		List<CustomerDTO> customerDTOs = customerService.findAll()
		        .stream()
		        .map(c -> new CustomerDTO(c.getId(), c.getName(), c.getCpf(), c.getCreatedAt()))
		        .toList();
		return ResponseEntity.ok(customerDTOs);
	}
	
	
	
}
