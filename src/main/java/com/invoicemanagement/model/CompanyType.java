package com.invoicemanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="companytype")
public class CompanyType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="companytypeid")
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CompanyType(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public CompanyType() {
		super();
		// TODO Auto-generated constructor stub
	}



}
