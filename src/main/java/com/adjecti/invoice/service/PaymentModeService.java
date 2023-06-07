package com.adjecti.invoice.service;

import java.util.List;

import com.adjecti.invoice.model.PaymentMode;

public interface PaymentModeService {
	public PaymentMode create(PaymentMode paymentMode);
	public List<PaymentMode> getAll();
	public void delete(long id); 
	public PaymentMode update(PaymentMode paymentMode, long id);
	public PaymentMode getById(long id);
}
