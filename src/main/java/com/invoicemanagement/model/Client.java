package com.invoicemanagement.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "clientid")
	private long id;
	@Column(name = "clientname")
	private String name;
	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.PERSIST })
	@JoinColumn(name = "addressId")
	private Address address;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "contactId")
	private Contact contact;
	private String bussinessName;
	private long companyType;
	private String primaryBussiness;
	private long taxDocNo1;
	private long taxDocNo2;
	private String taxes;

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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getBussinessName() {
		return bussinessName;
	}

	public void setBussinessName(String bussinessName) {
		this.bussinessName = bussinessName;
	}

	public long getCompanyType() {
		return companyType;
	}

	public void setCompanyType(long companyType) {
		this.companyType = companyType;
	}

	public String getPrimaryBussiness() {
		return primaryBussiness;
	}

	public void setPrimaryBussiness(String primaryBussiness) {
		this.primaryBussiness = primaryBussiness;
	}

	public long getTaxDocNo1() {
		return taxDocNo1;
	}

	public void setTaxDocNo1(long taxDocNo1) {
		this.taxDocNo1 = taxDocNo1;
	}

	public long getTaxDocNo2() {
		return taxDocNo2;
	}

	public void setTaxDocNo2(long taxDocNo2) {
		this.taxDocNo2 = taxDocNo2;
	}

	public String getTaxes() {
		return taxes;
	}

	public void setTaxes(String taxes) {
		this.taxes = taxes;
	}

	public Client(long id, String name, Address address) {
		super();
		this.id = id;
		this.name = name;
		// this.address = address;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

}
