package com.invoicemanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoicemanagement.model.Client;
import com.invoicemanagement.model.Contact;
import com.invoicemanagement.repository.ContactRepository;
import com.invoicemanagement.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService{
	@Autowired
	private ContactRepository contactRepository;

	@Override
	public Contact create(Contact contact) {
		// TODO Auto-generated method stub
		return contactRepository.save(contact);
	}

	@Override
	public List<Contact> getAll() {
		// TODO Auto-generated method stub
		return contactRepository.findAll();
	}

	@Override
	public Contact update(Contact contact, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}
	
}