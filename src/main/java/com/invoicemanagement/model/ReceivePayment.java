package com.invoicemanagement.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name ="tbl_recievePayment")
public class ReceivePayment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private long clientId;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "invoiceId")
	private Invoice invoice;
	
	@Column(name = "payableTotal")
	private long payableTotal;
	
	@Column(name = "balanceDue")
	private long balanceDue;
	
	@Column(name = "amountReceived")
	private long amountReceived;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "paymentModeId")
	private PaymentMode paymentMode;
	
	@Column(name = "amountPaid")
	private String amountPaid;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "dateOfPayment")
	private Date dateOfPayment;
	
	@Column(name = "transactionDetails")
	private String transactionDetails;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public long getPayableTotal() {
		return payableTotal;
	}

	public void setPayableTotal(long payableTotal) {
		this.payableTotal = payableTotal;
	}

	public long getBalanceDue() {
		return balanceDue;
	}

	public void setBalanceDue(long balanceDue) {
		this.balanceDue = balanceDue;
	}

	public long getAmountReceived() {
		return amountReceived;
	}

	public void setAmountReceived(long amountReceived) {
		this.amountReceived = amountReceived;
	}

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(String amountPaid) {
		this.amountPaid = amountPaid;
	}

	public Date getDateOfPayment() {
		return dateOfPayment;
	}

	public void setDateOfPayment(Date dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}

	public String getTransactionDetails() {
		return transactionDetails;
	}

	public void setTransactionDetails(String transactionDetails) {
		this.transactionDetails = transactionDetails;
	}

	public ReceivePayment(int id, long clientId, Invoice invoice, long payableTotal, long balanceDue,
			long amountReceived, PaymentMode paymentMode, String amountPaid, Date dateOfPayment,
			String transactionDetails) {
		super();
		this.id = id;
		this.clientId = clientId;
		this.invoice = invoice;
		this.payableTotal = payableTotal;
		this.balanceDue = balanceDue;
		this.amountReceived = amountReceived;
		this.paymentMode = paymentMode;
		this.amountPaid = amountPaid;
		this.dateOfPayment = dateOfPayment;
		this.transactionDetails = transactionDetails;
	}

	public ReceivePayment() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	


}

