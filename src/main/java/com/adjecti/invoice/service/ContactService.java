package com.adjecti.invoice.service;

import java.util.List;

import com.adjecti.invoice.model.Contact;

public interface ContactService {
	public Contact create(Contact contact);
	public List<Contact> getAll();
	public Contact update(Contact contact, long id);
	public void delete(long id); 
	

}
