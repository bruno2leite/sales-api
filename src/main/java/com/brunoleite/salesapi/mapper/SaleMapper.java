package com.brunoleite.salesapi.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.brunoleite.salesapi.dto.CustomerDTO;
import com.brunoleite.salesapi.dto.ItemResponseDTO;
import com.brunoleite.salesapi.dto.SaleResponseDTO;
import com.brunoleite.salesapi.model.Sale;
import com.brunoleite.salesapi.model.SaleItem;

@Component
public class SaleMapper {
	
	public SaleResponseDTO toSaleResponseDTO(Sale sale) {
        SaleResponseDTO dto = new SaleResponseDTO();
        dto.setId(sale.getId());

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(sale.getCustomer().getId());
        customerDTO.setName(sale.getCustomer().getName());
        dto.setCustomer(customerDTO);

        dto.setSaleDate(sale.getSaleDate());
        dto.setTotal(sale.getTotal());

        List<ItemResponseDTO> itemDTOs = new ArrayList<>();
        for (SaleItem item : sale.getItems()) {
            ItemResponseDTO itemDTO = new ItemResponseDTO();
            itemDTO.setProductId(item.getProduct().getId());
            itemDTO.setQuantity(item.getQuantity());
            itemDTO.setSubtotal(item.getSubtotal());
            itemDTOs.add(itemDTO);
        }
        dto.setItems(itemDTOs);

        return dto;
    }
	
	public ItemResponseDTO toItemResponseDTO(SaleItem item) {
        ItemResponseDTO dto = new ItemResponseDTO();
        dto.setProductId(item.getProduct().getId());
        dto.setQuantity(item.getQuantity());
        dto.setSubtotal(item.getSubtotal());
        return dto;
    }
}

