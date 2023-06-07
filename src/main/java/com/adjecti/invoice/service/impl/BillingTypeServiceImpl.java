package com.adjecti.invoice.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adjecti.invoice.exception.ResourceNotFoundException;
import com.adjecti.invoice.model.BillingCycle;
import com.adjecti.invoice.model.BillingType;
import com.adjecti.invoice.repository.BillingCycleRepository;
import com.adjecti.invoice.repository.BillingTypeRepository;
import com.adjecti.invoice.service.BillingTypeService;

@Service
public class BillingTypeServiceImpl implements BillingTypeService {

	private BillingTypeRepository billingTypeRepository;

	public BillingTypeServiceImpl(BillingTypeRepository billingTypeRepository) {
		super();
		this.billingTypeRepository = billingTypeRepository;
	}

	
	@Override
	public BillingType create(BillingType billingType) {
		return billingTypeRepository.save(billingType);
	}

	@Override
	public List<BillingType> getAll() {
		return billingTypeRepository.findAll();
	}

	@Override
	public BillingType update(BillingType billingType, long id) {
		BillingType existingBillingType = billingTypeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("BillingType", "Id", id));
		existingBillingType.setBillingTypeName(billingType.getBillingTypeName());
		return billingTypeRepository.save(existingBillingType);
	}

	@Override
	public void delete(long id) {
		// check whether a UserGroup exist or not
		billingTypeRepository.findById(id).orElseThrow(() -> new com.adjecti.invoice.exception.ResourceNotFoundException("billingType", "Id", id));
		billingTypeRepository.deleteById(id);
		
	}


	@Override
	public BillingType getById(long id) {
	return billingTypeRepository.findById(id).get();
	}

}
