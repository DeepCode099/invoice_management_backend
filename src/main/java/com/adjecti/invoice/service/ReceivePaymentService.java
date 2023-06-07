package com.adjecti.invoice.service;

import java.util.List;
import java.util.Map;

import com.adjecti.invoice.model.ReceivePayment;

public interface ReceivePaymentService {
	
	public ReceivePayment create(Map<String, Object> receivePayment)throws ClassNotFoundException;
	public List<ReceivePayment> getAll();
	
}
