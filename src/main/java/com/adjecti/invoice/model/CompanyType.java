package com.adjecti.invoice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="companytype")
public class CompanyType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="companytypeid")
	private int id;
	private String cname;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public CompanyType(int id, String cname) {
		super();
		this.id = id;
		this.cname = cname;
	}
	
	public CompanyType() {
		super();
		// TODO Auto-generated constructor stub
	}



}
