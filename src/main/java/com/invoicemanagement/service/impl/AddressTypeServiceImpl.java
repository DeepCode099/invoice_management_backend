package com.invoicemanagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.invoicemanagement.model.Address;
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
	return addressTypeRepository.findAll();
	}

	@Override
	public AddressType update(AddressType addressType, long id) {
		AddressType addresstype = addressTypeRepository.findById(id).get();
		if(addresstype!=null) {
			addresstype.setName(addressType.getName());
		}
		
		return addressTypeRepository.save(addresstype);
	}

	@Override
	public void delete(long id) {
	addressTypeRepository.deleteById(id);
		
	}

}
