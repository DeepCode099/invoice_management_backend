package com.invoicemanagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.invoicemanagement.exception.ResourceNotFoundException;
import com.invoicemanagement.model.BillingCycle;
import com.invoicemanagement.model.BillingType;
import com.invoicemanagement.repository.BillingCycleRepository;
import com.invoicemanagement.repository.BillingTypeRepository;
import com.invoicemanagement.service.BillingTypeService;

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
		billingTypeRepository.findById(id).orElseThrow(() -> new com.invoicemanagement.exception.ResourceNotFoundException("billingType", "Id", id));
		billingTypeRepository.deleteById(id);
		
	}


	@Override
	public BillingType getById(long id) {
	return billingTypeRepository.findById(id).get();
	}

}
