package com.invoicemanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_client_po_item")
public class ClientPurchaseOrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private float amount;
	private String itemDescription;
	private String itemName;
	private float price;
	private int qty;
	@ManyToOne()
	@JoinColumn(name ="purchaseOderId")
	private PurchaseOrder purchaseOrder;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public float getAmount() {
		return amount;
	}


	public void setAmount(float amount) {
		this.amount = amount;
	}


	public String getItemDescription() {
		return itemDescription;
	}


	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public int getQty() {
		return qty;
	}


	public void setQty(int qty) {
		this.qty = qty;
	}


	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}


	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}


	public ClientPurchaseOrderItem(int id, float amount, String itemDescription, String itemName, float price, int qty,
			PurchaseOrder purchaseOrder) {
		super();
		this.id = id;
		this.amount = amount;
		this.itemDescription = itemDescription;
		this.itemName = itemName;
		this.price = price;
		this.qty = qty;
		this.purchaseOrder = purchaseOrder;
	}


	public ClientPurchaseOrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}