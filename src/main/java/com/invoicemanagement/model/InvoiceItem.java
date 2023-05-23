package com.invoicemanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="tbl_invoiceItem")
public class InvoiceItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "amount")
	private double amount;
	@Column(name = "description")
	private String descrition;
	@Column(name = "part")
	private double part;
	@Column(name = "qty")
	private int quantity;
	@ManyToOne
	@JoinColumn(name = "poItemId")
	private ClientPurchaseOrderItem clientPurchaseOrderItem;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescrition() {
		return descrition;
	}
	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}
	public double getPart() {
		return part;
	}
	public void setPart(double part) {
		this.part = part;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public ClientPurchaseOrderItem getClientPurchaseOrderItem() {
		return clientPurchaseOrderItem;
	}
	public void setClientPurchaseOrderItem(ClientPurchaseOrderItem clientPurchaseOrderItem) {
		this.clientPurchaseOrderItem = clientPurchaseOrderItem;
	}
	public InvoiceItem(int id, double amount, String descrition, double part, int quantity,
			ClientPurchaseOrderItem clientPurchaseOrderItem) {
		super();
		this.id = id;
		this.amount = amount;
		this.descrition = descrition;
		this.part = part;
		this.quantity = quantity;
		this.clientPurchaseOrderItem = clientPurchaseOrderItem;
	}
	public InvoiceItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
}
