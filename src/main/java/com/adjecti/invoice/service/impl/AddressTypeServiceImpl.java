package com.adjecti.invoice.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adjecti.invoice.model.Address;
import com.adjecti.invoice.model.AddressType;
import com.adjecti.invoice.model.Client;
import com.adjecti.invoice.repository.AddressTypeRepository;
import com.adjecti.invoice.service.AddressTypeService;

@Service
public class AddressTypeServiceImpl implements AddressTypeService {

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
	public AddressType getById(long id) {
		return addressTypeRepository.findById(id).get();
	}

	@Override
	public AddressType update(AddressType addressType, long id) {
		AddressType addresstype = addressTypeRepository.findById(id).get();
		if (addresstype != null) {
			addresstype.setAname(addressType.getAname());
		}
		return addressTypeRepository.save(addresstype);
	}

	@Override
	public void delete(long id) {
		AddressType addressType = addressTypeRepository.findById(id).get();
		if (addressType != null) {
			addressType.setEnabled(1);
			addressTypeRepository.save(addressType);
		}
	}

	@Override
	public List<AddressType> findByEnabled() {
		return addressTypeRepository.findByEnabled();
	}

}
