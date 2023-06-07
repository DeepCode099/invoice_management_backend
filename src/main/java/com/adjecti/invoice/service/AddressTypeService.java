package com.adjecti.invoice.service;

import java.util.List;

import com.adjecti.invoice.model.AddressType;

public interface AddressTypeService {

	public AddressType create(AddressType addressType);
	public List<AddressType> getAll();
	public AddressType getById(long id);
	public AddressType update(AddressType addressType, long id);
	public void delete(long id); 
	public List<AddressType> findByEnabled();
	
}
