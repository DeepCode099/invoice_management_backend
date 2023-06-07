package com.adjecti.invoice.service;

import java.util.List;

import com.adjecti.invoice.model.BillingCycle;
import com.adjecti.invoice.model.Currency;

public interface BillingCycleService {
	
	public BillingCycle create(BillingCycle billingCycle);
	public List<BillingCycle> getAll();
	public BillingCycle update(BillingCycle billingCycle, long id);
	public void delete(long id); 
	public BillingCycle getById(long id);

}
