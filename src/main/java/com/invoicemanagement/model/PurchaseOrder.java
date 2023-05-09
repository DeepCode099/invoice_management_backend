package com.invoicemanagement.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="purchase_order")
public class PurchaseOrder {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "poNo")
	private long poNo;
	private String address;
	private Date poDate;
	private Date receivedDate;
	private Date deliveryDate;
	private String HSN;
	private boolean sow;
	private String billingAddress;
	private String shippingAddress;
	private String item;
	private String description;
	private long quality;
	private long price;
	private long amount;
	private String comments;
	private String termsAndConditions;
	private long subTotal;
	private long tax;
	private long others;
	private long grandTotal;
	private long advancePaid;
	private long balanceDue;
	public long getPoNo() {
		return poNo;
	}
	public void setPoNo(long poNo) {
		this.poNo = poNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getPoDate() {
		return poDate;
	}
	public void setPoDate(Date poDate) {
		this.poDate = poDate;
	}
	public Date getReceivedDate() {
		return receivedDate;
	}
	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getHSN() {
		return HSN;
	}
	public void setHSN(String hSN) {
		HSN = hSN;
	}
	public boolean isSow() {
		return sow;
	}
	public void setSow(boolean sow) {
		this.sow = sow;
	}
	public String getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getQuality() {
		return quality;
	}
	public void setQuality(long quality) {
		this.quality = quality;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getTermsAndConditions() {
		return termsAndConditions;
	}
	public void setTermsAndConditions(String termsAndConditions) {
		this.termsAndConditions = termsAndConditions;
	}
	public long getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(long subTotal) {
		this.subTotal = subTotal;
	}
	public long getTax() {
		return tax;
	}
	public void setTax(long tax) {
		this.tax = tax;
	}
	public long getOthers() {
		return others;
	}
	public void setOthers(long others) {
		this.others = others;
	}
	public long getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(long grandTotal) {
		this.grandTotal = grandTotal;
	}
	public long getAdvancePaid() {
		return advancePaid;
	}
	public void setAdvancePaid(long advancePaid) {
		this.advancePaid = advancePaid;
	}
	public long getBalanceDue() {
		return balanceDue;
	}
	public void setBalanceDue(long balanceDue) {
		this.balanceDue = balanceDue;
	}
	public PurchaseOrder(long poNo, String address, Date poDate, Date receivedDate, Date deliveryDate, String hSN,
			boolean sow, String billingAddress, String shippingAddress, String item, String description, long quality,
			long price, long amount, String comments, String termsAndConditions, long subTotal, long tax, long others,
			long grandTotal, long advancePaid, long balanceDue) {
		super();
		this.poNo = poNo;
		this.address = address;
		this.poDate = poDate;
		this.receivedDate = receivedDate;
		this.deliveryDate = deliveryDate;
		HSN = hSN;
		this.sow = sow;
		this.billingAddress = billingAddress;
		this.shippingAddress = shippingAddress;
		this.item = item;
		this.description = description;
		this.quality = quality;
		this.price = price;
		this.amount = amount;
		this.comments = comments;
		this.termsAndConditions = termsAndConditions;
		this.subTotal = subTotal;
		this.tax = tax;
		this.others = others;
		this.grandTotal = grandTotal;
		this.advancePaid = advancePaid;
		this.balanceDue = balanceDue;
	}
	public PurchaseOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

}
