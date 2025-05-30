package com.brunoleite.salesapi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class SaleResponseDTO {
	private Long id;
    private CustomerDTO customer;
    private LocalDate saleDate;
    private BigDecimal total;
    private List<ItemResponseDTO> items;
	

    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public CustomerDTO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
	public LocalDate getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(LocalDate saleDate) {
		this.saleDate = saleDate;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public List<ItemResponseDTO> getItems() {
		return items;
	}
	public void setItems(List<ItemResponseDTO> items) {
		this.items = items;
	}

    
}
