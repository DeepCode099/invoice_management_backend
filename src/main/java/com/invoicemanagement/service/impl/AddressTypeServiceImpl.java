package com.invoicemanagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.invoicemanagement.model.AddressType;
import com.invoicemanagement.repository.AddressTypeRepository;
import com.invoicemanagement.service.AddressTypeService;

@Service
public class AddressTypeServiceImpl implements AddressTypeService{

	private AddressTypeRepository addressTypeRepository;
	
	public AddressTypeServiceImpl(AddressTypeRepository addressTypeRepository) {
		super();
		this.addressTypeRepository = addressTypeRepository;
	}
	
	@Override
	public AddressType create(AddressType addressType) {
		return addressTypeRepository.save(addressType);
	}

	@Override
	public List<AddressType> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddressType update(AddressType addressType, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

}
