package com.invoicemanagement.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoicemanagement.model.Address;
import com.invoicemanagement.model.Client;
import com.invoicemanagement.model.ClientPurchaseOrderItem;
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
	public Client add(Map<String, Object> client) throws ClassNotFoundException{
		Client clientObject = new Client();
		Address address = new Address();
		Contact contact = new Contact();
		String companyTypeId =  client.get("companyType").toString();
		CompanyType companyType = companyTypeRepository.findById(Long.parseLong(companyTypeId)).get();
		ReflectionBeanUtil.mapClassFields(client, address);	
		ReflectionBeanUtil.mapClassFields(client, contact);
		ReflectionBeanUtil.mapClassFields(client, companyType);
		ReflectionBeanUtil.mapClassFields(client, clientObject);
		clientObject.setAddress(address);
		clientObject.setContact(contact);
		clientObject.setCompanytype(companyType);
		String enabled = client.get("enabled").toString();
		boolean isEnabled = Boolean.parseBoolean(enabled);
		if(isEnabled) {
			clientObject.setEnabled(isEnabled);
		}else {
		clientObject.setEnabled(false);
		}
		List<Tax> taxArrayList = new ArrayList<>();
		client.get("tax");
		List<String> taxList = (List<String>)client.get("tax");
		Client saveClient = clientRepository.save(clientObject);
		for(int i=0;i<taxList.size();i++) {
		String taxName = taxList.get(i);
			Tax tax =new Tax();
			tax.setName(taxName);
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
		Client clientObj = clientRepository.findById(id).get();
		if(clientObj!=null) {
			
		}
		return null;
	}

	@Override
	public void delete(long id) {
		clientRepository.deleteById(id);
	}

	@Override
	public Client getById(long id) {
		return clientRepository.findById(id).get();
	}
	
}
