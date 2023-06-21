package com.adjecti.invoice.service;

import java.util.List;
import java.util.Map;

import com.adjecti.invoice.model.ReceivePayment;

public interface ReceivePaymentService {
	
	public List<ReceivePayment> getAll();
	
	public ReceivePayment add(ReceivePayment receivePayment);	

}
