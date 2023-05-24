package com.invoicemanagement.model;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "purchase_order")
public class PurchaseOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private float advancePaid;
	private float balanceDue;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createdDate;
	private long currencyId;
	/*
	 * @DateTimeFormat(pattern = "yyyy-MM-dd")
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date deliveryDate;
	private boolean enabled;
	private float grandTotal;
	private String instructions;
	private float otherAmount;
	/*
	 * @DateTimeFormat(pattern = "yyyy-MM-dd")
	 * 
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date poDate;
	private String poFileUrl;
	private String poNumber;
	/*
	 * @DateTimeFormat(pattern = "yyyy-MM-dd")
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date receivedDate;
	private float subTotal;
	private float taxAmount;
	private String termsConditions;
	 private boolean sow;
	private String title;
	private String hsnSac;
	private String billingAddress;
	private String shippingAddress;

	@ManyToOne
	@JoinColumn(name = "billingCycleId")
	private BillingCycle billingCycle;
	@ManyToOne
	@JoinColumn(name = "clientId")
	private Client client;
	@ManyToOne
	@JoinColumn(name = "billingTypeId")
	private BillingType billingType;
	@OneToMany(mappedBy = "purchaseOrder")
	@JsonIgnore
	private List<ClientPurchaseOrderItem> clientPurchaseOrderItem;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getAdvancePaid() {
		return advancePaid;
	}

	public void setAdvancePaid(float advancePaid) {
		this.advancePaid = advancePaid;
	}

	public float getBalanceDue() {
		return balanceDue;
	}

	public void setBalanceDue(float balanceDue) {
		this.balanceDue = balanceDue;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public long getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(long currencyId) {
		this.currencyId = currencyId;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public float getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(float grandTotal) {
		this.grandTotal = grandTotal;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public float getOtherAmount() {
		return otherAmount;
	}

	public void setOtherAmount(float otherAmount) {
		this.otherAmount = otherAmount;
	}

	public Date getPoDate() {
		return poDate;
	}

	public void setPoDate(Date poDate) {
		this.poDate = poDate;
	}

	public String getPoFileUrl() {
		return poFileUrl;
	}

	public void setPoFileUrl(String poFileUrl) {
		this.poFileUrl = poFileUrl;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public Date getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}

	public float getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}

	public float getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(float taxAmount) {
		this.taxAmount = taxAmount;
	}

	public String getTermsConditions() {
		return termsConditions;
	}

	public void setTermsConditions(String termsConditions) {
		this.termsConditions = termsConditions;
	}

	public boolean isSow() {
		return sow;
	}

	public void setSow(boolean sow) {
		this.sow = sow;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHsnSac() {
		return hsnSac;
	}

	public void setHsnSac(String hsnSac) {
		this.hsnSac = hsnSac;
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

	public BillingCycle getBillingCycle() {
		return billingCycle;
	}

	public void setBillingCycle(BillingCycle billingCycle) {
		this.billingCycle = billingCycle;
	}

	public Client getClientId() {
		return client;
	}

	public void setClientId(Client client) {
		this.client = client;
	}

	public BillingType getBillingType() {
		return billingType;
	}

	public void setBillingType(BillingType billingType) {
		this.billingType = billingType;
	}

	public List<ClientPurchaseOrderItem> getClientPurchaseOrderItem() {
		return clientPurchaseOrderItem;
	}

	public void setClientPurchaseOrderItem(List<ClientPurchaseOrderItem> clientPurchaseOrderItem) {
		this.clientPurchaseOrderItem = clientPurchaseOrderItem;
	}

	public PurchaseOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

}