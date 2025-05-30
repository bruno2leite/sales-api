package com.brunoleite.salesapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunoleite.salesapi.dto.SaleRequestDTO;
import com.brunoleite.salesapi.dto.SaleResponseDTO;
import com.brunoleite.salesapi.mapper.SaleMapper;
import com.brunoleite.salesapi.model.Sale;
import com.brunoleite.salesapi.service.SaleService;

@RestController
@RequestMapping("/sales")
public class SaleController {
	private final SaleService saleService;
	private final SaleMapper saleMapper;

	public SaleController(SaleService saleService,
			              SaleMapper saleMapper){
		this.saleService = saleService;
		this.saleMapper = saleMapper;
	}

	@PostMapping
	public ResponseEntity<SaleResponseDTO> createSale(@RequestBody SaleRequestDTO dto){
		Sale sale = saleService.createSale(dto);
		SaleResponseDTO response = saleMapper.toSaleResponseDTO(sale);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping
	public ResponseEntity<List<SaleResponseDTO>> getAllSales(){
		List<Sale> sales = saleService.findAll();
		List<SaleResponseDTO> responseList = sales.stream()
				.map(saleMapper::toSaleResponseDTO)
				.toList();
		return ResponseEntity.ok(responseList);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SaleResponseDTO> getSaleById(@PathVariable Long id){
		Sale sale = saleService.findById(id);
		SaleResponseDTO response = saleMapper.toSaleResponseDTO(sale);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/customer/{customerId}")
	public ResponseEntity<List<SaleResponseDTO>> getSalesByCustomer(@PathVariable Long customerId){
		List<Sale> sales = saleService.findByCustomerId(customerId);
		List<SaleResponseDTO> responseList = sales.stream()
				.map(saleMapper::toSaleResponseDTO)
				.toList();
		return ResponseEntity.ok(responseList);
	}
}


