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
	public Client add(Map<String, Object> client) throws ClassNotFoundException{
		Client clientObject = new Client();
		Address address = new Address();
		Contact contact = new Contact();
		System.out.println("documentId-----"+client.get("docId"));
		String companyTypeId =  client.get("companyType").toString();
		CompanyType companyType = companyTypeRepository.findById(Long.parseLong(companyTypeId)).get();
		ReflectionBeanUtil.mapClassFields(client, address);	
		ReflectionBeanUtil.mapClassFields(client, contact);
		//ReflectionBeanUtil.mapClassFields(client, companyType);
		ReflectionBeanUtil.mapClassFields(client, clientObject);
		System.out.println("*" +clientObject.getDocId());
		clientObject.setAddress(address);
		clientObject.setEnabled(1);
		clientObject.setContact(contact);
		clientObject.setCompanytype(companyType);
		String exemptable = client.get("exemptable").toString();
		boolean isExemptable = Boolean.parseBoolean(exemptable);
		if(isExemptable) {
			clientObject.setExemptable(isExemptable);
		}else {
		clientObject.setExemptable(false);
		}
		List<Tax> taxArrayList = new ArrayList<>();
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
	public Client update(Map<String, Object>client, long id) {
		Client clientObj = clientRepository.findById(id).get();
		if(clientObj!=null) {
			Address address=clientObj.getAddress();
			Contact contact=clientObj.getContact();
			String companyTypeId =  client.get("companyType").toString();
			CompanyType companyType = companyTypeRepository.findById(Long.parseLong(companyTypeId)).get();
			ReflectionBeanUtil.mapClassFields(client, address);	
			ReflectionBeanUtil.mapClassFields(client, contact);
			ReflectionBeanUtil.mapClassFields(client, companyType);
			ReflectionBeanUtil.mapClassFields(client, clientObj);
			clientObj.setAddress(address);
			clientObj.setContact(contact);
			clientObj.setCompanytype(companyType);
			String enabled = client.get("enabled").toString();
			
			List<Tax> taxArrayList = new ArrayList<>();
			List<Tax> taxList = taxRepository.findByClient(clientObj);
			//List<String> taxList = (List<String>)client.get("tax");
			System.out.println(taxList);
			for(Tax tax :taxList) {
				tax.setName(taxList.get(0).getName());
				taxArrayList.add(tax);	
				taxRepository.save(tax);
				
			} 
		
		
	}
		return clientRepository.save(clientObj);
	}

	@Override
	public void delete(long id) {
		Client client = clientRepository.findById(id).get();
		client.setEnabled(0);
		clientRepository.save(client);
	}

	@Override
	public Client getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> getByEnabled() {
		return clientRepository.findByEnabled();
	}
	
}
