package com.invoicemanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "billingCycle")
public class BillingCycle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="billingcycleid")
	private long id;
	@Column(name ="billingcyclename")
	private String billingCycleName;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBillingCycleName() {
		return billingCycleName;
	}
	public void setBillingCycleName(String billingCycleName) {
		this.billingCycleName = billingCycleName;
	}
	public BillingCycle(long id, String billingCycleName) {
		super();
		this.id = id;
		this.billingCycleName = billingCycleName;
	}
	public BillingCycle() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
