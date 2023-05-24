package com.invoicemanagement.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name ="tbl_recievePayment")
public class ReceivePayment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "clientId")
	private long cliendId;
	@Column(name = "invoiceId")
	private long invoiceId;
	@Column(name = "payableTotal")
	private long payableTotal;
	@Column(name = "balanceDue")
	private long balanceDue;
	@Column(name = "amountReceived")
	private long amountReceived;
	/*
	 * @OneToOne
	 */@JoinColumn(name = "paymentModeId")
	private long paymentModeId;
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
	public long getCliendId() {
		return cliendId;
	}
	public void setCliendId(long cliendId) {
		this.cliendId = cliendId;
	}
	public long getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(long invoiceId) {
		this.invoiceId = invoiceId;
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
	public long getPaymentMode() {
		return paymentModeId;
	}
	public void setPaymentMode(long paymentModeId) {
		this.paymentModeId = paymentModeId;
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
	public ReceivePayment(int id, long cliendId, long invoiceId, long payableTotal, long balanceDue,
			long amountReceived, long paymentModeId, String amountPaid, Date dateOfPayment,
			String transactionDetails) {
		super();
		this.id = id;
		this.cliendId = cliendId;
		this.invoiceId = invoiceId;
		this.payableTotal = payableTotal;
		this.balanceDue = balanceDue;
		this.amountReceived = amountReceived;
		this.paymentModeId = paymentModeId;
		this.amountPaid = amountPaid;
		this.dateOfPayment = dateOfPayment;
		this.transactionDetails = transactionDetails;
	}
	public ReceivePayment() {
		super();
		// TODO Auto-generated constructor stub
	}




}
