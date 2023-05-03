package com.invoicemanagement.service;

import java.util.List;

import com.invoicemanagement.model.BillingType;

public interface BillingTypeService {

	
	public BillingType create(BillingType billingType);
	public List<BillingType> getAll();
	public BillingType update(BillingType billingType, long id);
	public void delete(long id); 
	
}
