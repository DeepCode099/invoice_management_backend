package com.invoicemanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "addressType")
public class AddressType{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="addressTypeId")
	private long id;
	private String aname;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public AddressType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

