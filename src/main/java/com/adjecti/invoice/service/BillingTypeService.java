package com.adjecti.invoice.service;

import java.util.List;

import com.adjecti.invoice.model.BillingType;
import com.adjecti.invoice.model.Currency;

public interface BillingTypeService {

	
	public BillingType create(BillingType billingType);
	public List<BillingType> getAll();
	public BillingType update(BillingType billingType, long id);
	public void delete(long id); 
	public BillingType getById(long id);
	
}
