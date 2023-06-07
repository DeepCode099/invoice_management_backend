package com.adjecti.invoice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adjecti.invoice.model.Address;
import com.adjecti.invoice.model.AddressType;
import com.adjecti.invoice.repository.AddressRepository;
import com.adjecti.invoice.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;
	@Override
	public Address create(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public List<Address> getAll() {
		return addressRepository.findAll();
	}

	@Override
	public Address update(Address address, long id) {
	
		return null;
	}

	@Override
	public void delete(long id) {
		addressRepository.findById(id);	
	}

	@Override
	public Address getById(long id) {
		return addressRepository.findById(id).get();
	}


	
}
