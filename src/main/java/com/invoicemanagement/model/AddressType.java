package com.invoicemanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "addressType")
public class AddressType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="addressTypeId")
	private long id;
	private String name;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AddressType(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public AddressType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

