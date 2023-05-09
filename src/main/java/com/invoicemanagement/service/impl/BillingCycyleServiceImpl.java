package com.invoicemanagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.invoicemanagement.model.BillingCycle;
import com.invoicemanagement.repository.BillingCycleRepository;
import com.invoicemanagement.service.BillingCycleService;

@Service
public class BillingCycyleServiceImpl implements BillingCycleService{

	private BillingCycleRepository billingCycleRepository;

	public BillingCycyleServiceImpl(BillingCycleRepository billingCycleRepository) {
		super();
		this.billingCycleRepository = billingCycleRepository;
	}

	
	@Override
	public BillingCycle create(BillingCycle billingCycle) {
		return billingCycleRepository.save(billingCycle);
	}

	@Override
	public List<BillingCycle> getAll() {
		return billingCycleRepository.findAll();
	}

	@Override
	public BillingCycle update(BillingCycle billingCycle, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

}
