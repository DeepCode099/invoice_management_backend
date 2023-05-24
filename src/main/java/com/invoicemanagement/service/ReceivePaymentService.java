package com.invoicemanagement.service;

import java.util.List;
import java.util.Map;

import com.invoicemanagement.model.ReceivePayment;

public interface ReceivePaymentService {
	
	public ReceivePayment add(Map<Object, Object> receivePayment)throws ClassNotFoundException;
	public List<ReceivePayment> getAll();
	

}
