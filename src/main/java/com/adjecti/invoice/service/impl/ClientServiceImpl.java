package com.adjecti.invoice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adjecti.invoice.model.Address;
import com.adjecti.invoice.model.AddressType;
import com.adjecti.invoice.model.Client;
import com.adjecti.invoice.model.CompanyType;
import com.adjecti.invoice.model.Contact;
import com.adjecti.invoice.model.Tax;
import com.adjecti.invoice.repository.AddressRepository;
import com.adjecti.invoice.repository.AddressTypeRepository;
import com.adjecti.invoice.repository.ClientRepository;
import com.adjecti.invoice.repository.CompanyTypeRepository;
import com.adjecti.invoice.repository.ContactRepository;
import com.adjecti.invoice.repository.TaxRepository;
import com.adjecti.invoice.service.ClientService;
import com.adjecti.invoice.util.ReflectionBeanUtil;

@Service
public class ClientServiceImpl implements ClientService {

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
	public Client add(Map<String, Object> client) throws ClassNotFoundException {
		Client clientObject = new Client();
		Address address = new Address();
		Contact contact = new Contact();
		String addressType = client.get("addressType").toString();
		AddressType addressType2 = addressTypeRepository.findById(Long.parseLong(addressType)).get();
		String companyTypeId = client.get("companyType").toString();
		CompanyType companyType = companyTypeRepository.findById(Long.parseLong(companyTypeId)).get();
		ReflectionBeanUtil.mapClassFields(client, address);
		ReflectionBeanUtil.mapClassFields(client, contact);
		ReflectionBeanUtil.mapClassFields(client, clientObject);
		address.setAddressType(addressType2);
		clientObject.setAddress(address);
		clientObject.setContact(contact);
		clientObject.setCompanytype(companyType);
		String exemptable = client.get("exemptable").toString();
		boolean isExemptable = Boolean.parseBoolean(exemptable);
		if (isExemptable) {
			clientObject.setExemptable(isExemptable);
		} else {
			clientObject.setExemptable(false);
		}
		List<Tax> taxArrayList = new ArrayList<>();
		String taxData = client.get("tax").toString();
		Client saveClient = clientRepository.save(clientObject);
		if (taxData.substring(0, 1) == "[") {
			taxData = taxData.substring(1, taxData.length() - 1);
			String[] elements = taxData.split(", ");
			for (String taxElement : elements) {
				Tax tax = new Tax();
				tax.setName(taxElement);
				tax.setClient(saveClient);
				taxRepository.save(tax);
			}
		} else {
			Tax tax = new Tax();
			tax.setName(taxData);
			tax.setClient(saveClient);
			taxArrayList.add(tax);
			taxRepository.save(tax);
		}

		return saveClient;
	}

	@Override
	public Client update(Map<String, Object> client, long id) {
		Client clientObj = clientRepository.findById(id).get();
		if (clientObj != null) {
			Address address = clientObj.getAddress();
			if (address != null) {
				System.out.println("ad" + address.getId());
				ReflectionBeanUtil.mapClassFields(client, address);
				clientObj.setAddress(address);
			}
			Contact contact = clientObj.getContact();
			if (contact != null) {
				ReflectionBeanUtil.mapClassFields(client, contact);
				clientObj.setContact(contact);
			}
			CompanyType company = clientObj.getCompanytype();
			if (company != null) {
				String companyTypeId = client.get("companyType").toString();
				CompanyType companyType = companyTypeRepository.findById(Long.parseLong(companyTypeId)).get();
				clientObj.setCompanytype(companyType);
			}
			ReflectionBeanUtil.mapClassFields(client, clientObj);
			List<Tax> taxArrayList = new ArrayList<>();
			List<Tax> taxList = taxRepository.findByClient(clientObj);
			for (Tax tax : taxList) {

				String taxData = client.get("tax").toString();
				Client saveClient = clientRepository.save(clientObj);

				if (taxData.substring(0, 1) == "[") {
					taxData = taxData.substring(1, taxData.length() - 1);

					String[] elements = taxData.split(", ");

					System.out.println("length" + elements.length);
					for (String taxElement : elements) {
						System.out.println("length" + elements.length);
						tax.setName(taxElement);
						tax.setClient(saveClient);
						taxRepository.save(tax);
					}
				} else {

					tax.setName(taxData);
					tax.setClient(saveClient);
					taxArrayList.add(tax);
					taxRepository.save(tax);
					break;
				}
			}
		}
		return clientRepository.save(clientObj);
	}

	@Override
	public void delete(long id) {
		Client client = clientRepository.findById(id).get();
		client.setEnabled(1);
		clientRepository.save(client);
	}

	@Override
	public Client getById(long id) {
		Client client = clientRepository.findById(id).get();
		return client;
	}

	@Override
	public List<Client> getAll() {
		return clientRepository.findByEnabled();
	}

}
