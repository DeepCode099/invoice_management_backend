package com.adjecti.invoice.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@Column(name = "invoice_id")
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

	@OneToMany(mappedBy = "invoice")
	@JsonIgnore
	private List<InvoiceItem> invoiceItems;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "clientId" )
	private Client client;

	@ManyToOne
	@JoinColumn(name = "purchaseOrderId")
	private PurchaseOrder purchaseOrder;

	private int enabled;
	
	private String comments;
	
	
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

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

		public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}



}
