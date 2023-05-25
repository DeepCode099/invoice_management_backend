package com.invoicemanagement.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoicemanagement.model.ClientPurchaseOrderItem;
import com.invoicemanagement.model.Currency;
import com.invoicemanagement.model.Invoice;
import com.invoicemanagement.model.InvoiceItem;
import com.invoicemanagement.model.PurchaseOrder;
import com.invoicemanagement.repository.CurrencyRepository;
import com.invoicemanagement.repository.InvoiceItemRepository;
import com.invoicemanagement.repository.InvoiceRepository;
import com.invoicemanagement.repository.PurchaseOrderRepository;
import com.invoicemanagement.service.InvoiceService;
import com.invoicemanagement.util.ReflectionBeanUtil;

@Service
public class InvoiceServiceImpl implements InvoiceService{

	@Autowired
	private InvoiceRepository invoiceRepository;
	
	@Autowired
	private PurchaseOrderRepository  purchaseOrderRepository; 

	@Autowired
	private InvoiceItemRepository invoiceItemRepository;
	
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
		
		
		  String purchaserOrderId = invoice.get("poNumber").toString();
		  
		  PurchaseOrder purchaseOrder = purchaseOrderRepository.findById(Integer.parseInt(purchaserOrderId)).get();
		 	//System.out.println("purchaserOrder 0--->"+purchaseOrder);
		
		ReflectionBeanUtil.mapClassFields(invoice, invoiceObject);
		 invoiceObject.setPurchaseOrder(purchaseOrder); 
	    System.out.println("keyset -->"+invoice.keySet());
	    System.out.println("invoice Items -->"+invoice.get("invoiceItems"));
	  List<InvoiceItem> invoiceItemList = new ArrayList<>();
	  List<Map<String, String>> invoiceItems = (List<Map<String, String>>)invoice.get("invoiceItems");
	  System.out.println("invoiceItems --->"+invoiceItems);
	  Invoice saveInvoice =  invoiceRepository.save(invoiceObject);
	  System.out.println("invoice object --->>."+invoiceObject);
   	  for(int i=0;i<invoiceItems.size();i++) {
		  Map<String ,String> items = invoiceItems.get(i);
		  InvoiceItem invoiceItem = new InvoiceItem();
		  invoiceItem.setQuantity(Integer.parseInt(items.get("qty").toString()));
		  invoiceItem.setAmount(Double.parseDouble(items.get("amount").toString()));
		  invoiceItem.setDescrition(items.get("description"));
		  invoiceItem.setPart(Double.parseDouble(items.get("part")));
		  invoiceItem.setInvoice(saveInvoice);
		  invoiceItemList.add(invoiceItem);
		  invoiceItemRepository.save(invoiceItem);
	  }
   	  invoiceObject.setInvoiceItems(invoiceItemList);
	  return saveInvoice; 
	  
	}

}
