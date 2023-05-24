package com.invoicemanagement.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "clientid")
	private long id;
	@Column(name = "clientname")
	private String name;
	private String bussinessName;
	private String primaryBussiness;
	private long taxDocNo1;
	private long taxDocNo2;
	private String taxes;
	private boolean enabled;

	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.PERSIST })
	@JoinColumn(name = "addressId")
	private Address address;
	@ManyToOne()
	private CompanyType companytype;

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Date getCreateOn() {
		return createOn;
	}

	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}

	public Date getUpdateOn() {
		return updateOn;
	}

	public void setUpdateOn(Date updateOn) {
		this.updateOn = updateOn;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "contactId")
	private Contact contact;
	@JsonIgnore
	@OneToMany(mappedBy = "client")
	private List<Tax> tax;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createOn;
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateOn;
	private String createdby;
	private String updatedBy;

	
	@PrePersist
	protected void prePersist() {
		if (this.createOn == null)
			createOn = new Date();

	}

	@PreUpdate
	protected void preUpdate() {
		this.updateOn = new Date();
	}
	public List<Tax> getTax() {
		return tax;
	}

	public void setTax(List<Tax> tax) {
		this.tax = tax;
	}

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

	public Contact getContact() {
		return contact;
	}


	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public CompanyType getCompanytype() {
		return companytype;
	}

	public void setCompanytype(CompanyType companytype) {
		this.companytype = companytype;
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
