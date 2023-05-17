package com.invoicemanagement.service;

import java.util.List;

import com.invoicemanagement.model.BillingCycle;
import com.invoicemanagement.model.Currency;

public interface BillingCycleService {
	
	public BillingCycle create(BillingCycle billingCycle);
	public List<BillingCycle> getAll();
	public BillingCycle update(BillingCycle billingCycle, long id);
	public void delete(long id); 
	public BillingCycle getById(long id);

}
