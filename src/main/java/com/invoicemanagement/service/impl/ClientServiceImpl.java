package com.invoicemanagement.service.impl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import com.invoicemanagement.util.ReflectionBeanUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoicemanagement.model.Address;
import com.invoicemanagement.model.AddressType;
import com.invoicemanagement.model.Client;
import com.invoicemanagement.repository.AddressRepository;
import com.invoicemanagement.repository.AddressTypeRepository;
import com.invoicemanagement.repository.ClientRepository;
import com.invoicemanagement.service.ClientService;

import jakarta.persistence.Entity;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private AddressTypeRepository addressTypeRepository;
	@Override
	public Client add(Map<Object, Object> client) throws ClassNotFoundException{
		Client clientObject = new Client();
		Address address = new Address();
		ReflectionBeanUtil.mapClassFields(client, address);
		ReflectionBeanUtil.mapClassFields(client, clientObject);
		addressRepository.save(address);
		clientObject.setAddress(address);
		return clientRepository.save(clientObject);
	}

	@Override
	public List<Client> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client update(Client client, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}
	
public void myFunction(Map<Object, Object> map, Object entity) throws ClassNotFoundException {
		for (Field field : entity.getClass().getDeclaredFields()) {
		field.setAccessible(true);
			String fieldType =field.getType().getSimpleName();
			
			try {
				if (field.getName() != "id")
				{
					if(fieldType.equals("long")) {
						
						field.set(entity,Long.parseLong(map.get(field.getName()).toString()));
					}
					else if (fieldType.equals("int")) {
					
					field.set(entity,  Integer.parseInt(map.get(field.getName()).toString()));
					}
					else {
						field.set(entity,  map.get(field.getName()));
					}
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
}