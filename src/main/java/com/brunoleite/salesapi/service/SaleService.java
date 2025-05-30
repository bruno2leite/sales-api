package com.brunoleite.salesapi.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.brunoleite.salesapi.dto.ItemDTO;
import com.brunoleite.salesapi.dto.SaleRequestDTO;
import com.brunoleite.salesapi.model.Customer;
import com.brunoleite.salesapi.model.Product;
import com.brunoleite.salesapi.model.Sale;
import com.brunoleite.salesapi.model.SaleItem;
import com.brunoleite.salesapi.repository.CustomerRepository;
import com.brunoleite.salesapi.repository.ProductRepository;
import com.brunoleite.salesapi.repository.SaleRepository;

@Service
public class SaleService {
	private final SaleRepository saleRepository;
	private final ProductRepository productRepository;
	private final CustomerRepository customerRepository;

	public SaleService(SaleRepository saleRepository, 
					   ProductRepository productRepository, 
					   CustomerRepository customerRepository) {
		this.saleRepository = saleRepository;
		this.productRepository = productRepository;
		this.customerRepository = customerRepository;
		
	}

	public Sale createSale(SaleRequestDTO dto) {
		Customer customer = customerRepository.findById(dto.getCustomerId())
				.orElseThrow(() -> new RuntimeException("Customer Not Found"));
		
		Sale sale = new Sale();
		sale.setCustomer(customer);
		sale.setSaleDate(LocalDate.now());
		
		List<SaleItem> items = new ArrayList<>();
        BigDecimal total = BigDecimal.ZERO;
		
		for(ItemDTO itemDTO : dto.getItems()) {
			Product product = productRepository.findById(itemDTO.getProductId())
					.orElseThrow(() -> new RuntimeException("Product not found"));
					
			if (product.getStock() < itemDTO.getQuantity()) {
				throw new RuntimeException("Not enough stock for product: " + product.getName());
			}
		
		
			product.setStock(product.getStock() - itemDTO.getQuantity());
		
			BigDecimal subtotal = product.getPrice().multiply(BigDecimal.valueOf(itemDTO.getQuantity()));
		
			SaleItem item = new SaleItem();
			item.setProduct(product);
			item.setQuantity(itemDTO.getQuantity());
			item.setSubtotal(subtotal);
			item.setSale(sale);
		
			items.add(item);
			total = total.add(subtotal);
		
		}
	
		sale.setItems(items);
		sale.setTotal(total);
	
		return saleRepository.save(sale);
	}
	
	public List<Sale> findAll(){
		return saleRepository.findAll();
	}
	
	public Sale findById(Long id) {
		return saleRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Sale not found"));
	}

	public List<Sale> findByCustomerId(Long customerId) {
	    return saleRepository.findByCustomerId(customerId);
	}
	
}
