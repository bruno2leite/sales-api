package com.brunoleite.salesapi.dto;

import java.util.List;

public class SaleRequestDTO {
	private Long customerId;
	private List<ItemDTO> items;

	
	public Long getCustomerId() {
		return customerId;
	}

	public List<ItemDTO> getItems() {
		return items;
	}

	public void setItems(List<ItemDTO> items) {
		this.items = items;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	
}
