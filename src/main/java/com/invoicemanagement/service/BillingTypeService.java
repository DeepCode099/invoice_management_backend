package com.invoicemanagement.service;

import java.util.List;

import com.invoicemanagement.model.BillingType;
import com.invoicemanagement.model.Currency;

public interface BillingTypeService {

	
	public BillingType create(BillingType billingType);
	public List<BillingType> getAll();
	public BillingType update(BillingType billingType, long id);
	public void delete(long id); 
	public BillingType getById(long id);
	
}
