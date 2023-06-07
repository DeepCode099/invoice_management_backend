package com.adjecti.invoice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	@JoinColumn(name ="invoiceId")
	private Invoice invoice;

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

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public InvoiceItem(int id, double amount, String descrition, double part, int quantity, Invoice invoice) {
		super();
		this.id = id;
		this.amount = amount;
		this.descrition = descrition;
		this.part = part;
		this.quantity = quantity;
		this.invoice = invoice;
	}

	public InvoiceItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
		
	
}
