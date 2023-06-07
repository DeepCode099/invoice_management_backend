package com.adjecti.invoice.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adjecti.invoice.exception.ResourceNotFoundException;
import com.adjecti.invoice.model.BillingCycle;
import com.adjecti.invoice.repository.BillingCycleRepository;
import com.adjecti.invoice.service.BillingCycleService;

@Service
public class BillingCycyleServiceImpl implements BillingCycleService {

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

		BillingCycle existingBillingCycle = billingCycleRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("BillingCycle", "Id", id));
		existingBillingCycle.setBillingCycleName(billingCycle.getBillingCycleName());
		return billingCycleRepository.save(existingBillingCycle);
	}

	@Override
	public void delete(long id) {
		// check whether a user exist or not
		billingCycleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("BillingCycle", "Id", id));
		billingCycleRepository.deleteById(id);
	}

	@Override
	public BillingCycle getById(long id) {
		return billingCycleRepository.findById(id).get();
	}

}
