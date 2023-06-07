package com.adjecti.invoice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adjecti.invoice.model.Client;
import com.adjecti.invoice.model.Contact;
import com.adjecti.invoice.repository.ContactRepository;
import com.adjecti.invoice.service.ContactService;

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