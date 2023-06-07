package com.adjecti.invoice.service;

import java.util.List;
import java.util.Map;

import com.adjecti.invoice.model.Invoice;

public interface InvoiceService {

	public Invoice create(Map<String,Object> invoice);
	public List<Invoice> getAll();
	public void delete(int id); 
	public Invoice update(Invoice invoice, long id);
	public Invoice getById(int id);
	
	public Invoice update(Map<String,Object> invoice,int id );
}
