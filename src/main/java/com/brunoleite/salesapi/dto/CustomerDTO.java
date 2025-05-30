package com.brunoleite.salesapi.dto;

import java.time.LocalDate;

public class CustomerDTO {
	private Long id;
    private String name;
    private String cpf;
    private LocalDate createdAt;
	
    public CustomerDTO() {
    	
    }
    
    public CustomerDTO(Long id, String name, String cpf, LocalDate createdAt) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.createdAt = createdAt;
    }
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}
    
	
    
}
