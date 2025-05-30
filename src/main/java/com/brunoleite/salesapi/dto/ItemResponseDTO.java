package com.brunoleite.salesapi.dto;

import java.math.BigDecimal;

public class ItemResponseDTO {
	
	private Long productId;
    private int quantity;
    private BigDecimal subtotal;
	
    
    public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

    
    
}
