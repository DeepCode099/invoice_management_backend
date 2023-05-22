package com.invoicemanagement.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoicemanagement.model.Address;
import com.invoicemanagement.model.Client;
import com.invoicemanagement.model.CompanyType;
import com.invoicemanagement.model.Contact;
import com.invoicemanagement.model.Tax;
import com.invoicemanagement.repository.AddressRepository;
import com.invoicemanagement.repository.AddressTypeRepository;
import com.invoicemanagement.repository.ClientRepository;
import com.invoicemanagement.repository.CompanyTypeRepository;
import com.invoicemanagement.repository.ContactRepository;
import com.invoicemanagement.repository.TaxRepository;
import com.invoicemanagement.service.ClientService;
import com.invoicemanagement.util.ReflectionBeanUtil;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private AddressTypeRepository addressTypeRepository;
	@Autowired
	private ContactRepository contactRepository;
	@Autowired
	private CompanyTypeRepository companyTypeRepository;
	@Autowired
	private TaxRepository taxRepository;
	
	@Override
	public Client add(Map<Object, Object> client) throws ClassNotFoundException{
		Client clientObject = new Client();
		Address address = new Address();
		Contact contact = new Contact();
		List<Tax> taxArrayList = new ArrayList<>();
		List <Tax> taxList = (List<Tax>)client.get("tax");
		Object[] objects = taxList.toArray();
		String companyTypeId =  client.get("companyType").toString();
		System.out.println(companyTypeId);
		CompanyType companyType = companyTypeRepository.findById(Long.parseLong(companyTypeId)).get();
		ReflectionBeanUtil.mapClassFields(client, address);	
		ReflectionBeanUtil.mapClassFields(client, contact);
		ReflectionBeanUtil.mapClassFields(client, companyType);
		ReflectionBeanUtil.mapClassFields(client, clientObject);
		addressRepository.save(address);
		contactRepository.save(contact);
		clientObject.setAddress(address);
		clientObject.setContact(contact);
		clientObject.setCompanytype(companyType);
		clientObject.setTax(taxArrayList);
		Client saveClient = clientRepository.save(clientObject);
		for(int i=0; i<objects.length; i++) {
			Tax tax =new Tax();
			tax.setName(objects[i].toString());
			tax.setClient(saveClient);
			taxArrayList.add(tax);	
			taxRepository.save(tax);
		} 
		return saveClient;
	}

	@Override
	public List<Client> getAll() {
		return clientRepository.findAll();
	}

	@Override
	public Client update(Client client, long id) {
		return null;
	}

	@Override
	public void delete(long id) {
		clientRepository.deleteById(id);
	}
	
	/*
	 * public void myFunction(Map<Object, Object> map, Object entity) throws
	 * ClassNotFoundException { for (Field field :
	 * entity.getClass().getDeclaredFields()) { field.setAccessible(true); String
	 * fieldType =field.getType().getSimpleName();
	 * 
	 * try { if (field.getName() != "id") { if(fieldType.equals("long")) {
	 * 
	 * field.set(entity,Long.parseLong(map.get(field.getName()).toString())); } else
	 * if (fieldType.equals("int")) {
	 * 
	 * field.set(entity, Integer.parseInt(map.get(field.getName()).toString())); }
	 * else { field.set(entity, map.get(field.getName())); } } } catch
	 * (IllegalAccessException e) { e.printStackTrace(); } } }
	 */
}
