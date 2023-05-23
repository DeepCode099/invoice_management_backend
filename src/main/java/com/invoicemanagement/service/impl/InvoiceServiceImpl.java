package com.invoicemanagement.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoicemanagement.model.Invoice;
import com.invoicemanagement.repository.InvoiceRepository;
import com.invoicemanagement.service.InvoiceService;
import com.invoicemanagement.util.ReflectionBeanUtil;

@Service
public class InvoiceServiceImpl implements InvoiceService{

	@Autowired
	private InvoiceRepository invoiceRepository;
	
	@Override
	public List<Invoice> getAll() {
		return invoiceRepository.findAll();
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Invoice update(Invoice invoice, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Invoice getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Invoice create(Map<String, Object> invoice) {
		Invoice invoiceObject = new Invoice();
		
		System.out.println("dfdf-->"+invoice.keySet());
		
		
		ReflectionBeanUtil.mapClassFields(invoice, invoiceObject);
		
		return invoiceRepository.save(invoiceObject);
	}

}
