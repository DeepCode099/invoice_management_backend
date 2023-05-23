package com.invoicemanagement.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

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
import jakarta.persistence.Table;

@Entity
@Table(name ="tbl_invoice")
public class Invoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "termsConditions")
	private String termsConditions;

	@Column(name = "subTotal")
	private double subTotal;

	@Column(name = "invoiceNo")
	private String invoiceNo;

	@Column(name = "invoiceDate")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date invoiceDate;

	@Column(name = "grandTotal")
	private double grandTotal;
	@Column(name = "dueDate")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dueDate;

	@Column(name = "currency")
	private String currency;

	@Column(name = "createdDate")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createdDate;
	@Column(name = "balanceDue")
	private double balanceDue;

	@Column(name = "advancePaid")
	private double advancePaid;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "invoiceId")
	private List<InvoiceItem> invoiceItems;
	
	//@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	@ManyToOne
	@JoinColumn(name = "clientId")
	private Client client;

	@ManyToOne
	@JoinColumn(name = "purchaseOrderId")
	private PurchaseOrder purchaseOrder;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTermsConditions() {
		return termsConditions;
	}

	public void setTermsConditions(String termsConditions) {
		this.termsConditions = termsConditions;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public double getBalanceDue() {
		return balanceDue;
	}

	public void setBalanceDue(double balanceDue) {
		this.balanceDue = balanceDue;
	}

	public double getAdvancePaid() {
		return advancePaid;
	}

	public void setAdvancePaid(double advancePaid) {
		this.advancePaid = advancePaid;
	}

	public List<InvoiceItem> getInvoiceItems() {
		return invoiceItems;
	}

	public void setInvoiceItems(List<InvoiceItem> invoiceItems) {
		this.invoiceItems = invoiceItems;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public Invoice(int id, String termsConditions, double subTotal, String invoiceNo, Date invoiceDate,
			double grandTotal, Date dueDate, String currency, Date createdDate, double balanceDue, double advancePaid,
			List<InvoiceItem> invoiceItems, Client client, PurchaseOrder purchaseOrder) {
		super();
		this.id = id;
		this.termsConditions = termsConditions;
		this.subTotal = subTotal;
		this.invoiceNo = invoiceNo;
		this.invoiceDate = invoiceDate;
		this.grandTotal = grandTotal;
		this.dueDate = dueDate;
		this.currency = currency;
		this.createdDate = createdDate;
		this.balanceDue = balanceDue;
		this.advancePaid = advancePaid;
		this.invoiceItems = invoiceItems;
		this.client = client;
		this.purchaseOrder = purchaseOrder;
	}

	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
}
