package com.adjecti.invoice.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "purchase_order")
public class PurchaseOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private float advancePaid;
	private float balanceDue;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Kolkata")
	private Date createdDate;
	private long currencyId;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Kolkata")
	private Date deliveryDate;
	private int enabled;
	private float grandTotal;
	private String instructions;
	private float otherAmount;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Kolkata")
	private Date poDate;
	private String poFileUrl;
	private String poNumber;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Kolkata")
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
	@JoinColumn(name = "billingTypeId")
	private BillingType billingType;
	@OneToMany(mappedBy = "purchaseOrder")
    @JsonIgnore
	private List<ClientPurchaseOrderItem> clientPurchaseOrderItem;
	@ManyToOne
	@JoinColumn(name = "clientId")
	private Client client;
	
	private long docId;	

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

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public long getDocId() {
		return docId;
	}

	public void setDocId(long docId) {
		this.docId = docId;
	}

	

}