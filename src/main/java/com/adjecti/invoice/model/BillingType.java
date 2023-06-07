package com.adjecti.invoice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="billingtype")
public class BillingType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="billingtypeid")
	private long id;
	@Column(name="billingtypename")
	private String billingTypeName;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBillingTypeName() {
		return billingTypeName;
	}
	public void setBillingTypeName(String billingTypeName) {
		this.billingTypeName = billingTypeName;
	}
	public BillingType(long id, String billingTypeName) {
		super();
		this.id = id;
		this.billingTypeName = billingTypeName;
	}
	public BillingType() {
		super();
		// TODO Auto-generated constructor stub
	}
	


}
