package com.invoicemanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoicemanagement.model.Address;
import com.invoicemanagement.repository.AddressRepository;
import com.invoicemanagement.service.AddressService;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address update(Address address, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

}
