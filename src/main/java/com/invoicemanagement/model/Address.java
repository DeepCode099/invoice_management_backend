
package com.invoicemanagement.model;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "addressid")
	private int id;
	
	private String address1;
	private String address2; 
	private String city;
	private String email;
	private String fax;
	private String mobile;
	private String phone;
	private String pincode;
	private String state;
	private String website;
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

	/*
	 * @OneToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "addresstypeid") private AddressType addressType;
	 */

	/*
	 * @OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH,
	 * CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST })
	 * 
	 * @JoinColumn(name = "type_id")
	 * 
	 * @OnDelete(action = OnDeleteAction.NO_ACTION)
	 */
	// @NotNull(message = "Please select address type")
	// private AddressType addressType;

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

	// @NotNull
//	@NotBlank(message = "Please select country")
	private String country;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	/*
	 * public String getEmail() { return email; }
	 * 
	 * public void setEmail(String email) { this.email = email; }
	 */

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	/*
	 * public AddressType getAddressType() { return addressType; }
	 * 
	 * public void setAddressType(AddressType addressType) { this.addressType =
	 * addressType; }
	 */

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Address(int id, String address1, String address2, String city, String email, String fax, String mobile,
			String phone, String pincode, String state, String website, AddressType addressType, String country) {
		super();
		this.id = id;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		//this.email = email;
		this.fax = fax;
		this.mobile = mobile;
		this.phone = phone;
		this.pincode = pincode;
		this.state = state;
		this.website = website;
		//this.addressType = addressType;
		this.country = country;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

}
