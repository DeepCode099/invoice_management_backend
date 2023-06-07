package com.adjecti.invoice.service;

import java.util.List;

import com.adjecti.invoice.model.Address;

public interface AddressService {

	public Address create(Address address);
	public List<Address> getAll();
	public Address update(Address address, long id);
	public void delete(long id); 
	
	public Address getById(long id);
}
