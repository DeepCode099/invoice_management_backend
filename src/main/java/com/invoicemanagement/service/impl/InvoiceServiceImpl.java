package com.invoicemanagement.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoicemanagement.model.Client;
import com.invoicemanagement.model.ClientPurchaseOrderItem;
import com.invoicemanagement.model.Currency;
import com.invoicemanagement.model.Invoice;
import com.invoicemanagement.model.InvoiceItem;
import com.invoicemanagement.model.PurchaseOrder;
import com.invoicemanagement.repository.ClientRepository;
import com.invoicemanagement.repository.CurrencyRepository;
import com.invoicemanagement.repository.InvoiceItemRepository;
import com.invoicemanagement.repository.InvoiceRepository;
import com.invoicemanagement.repository.PurchaseOrderRepository;
import com.invoicemanagement.service.InvoiceService;
import com.invoicemanagement.util.ReflectionBeanUtil;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;

	@Autowired
	private InvoiceItemRepository invoiceItemRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public List<Invoice> getAll() {
		return invoiceRepository.getAllByEnabled();
	}

	@Override
	public void delete(int id) {
	Invoice invoice =	invoiceRepository.findById(id).get();
	System.out.println("delete invoice");
	invoice.setEnabled(0);
	invoiceRepository.save(invoice);
	}

	@Override
	public Invoice update(Invoice invoice, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Invoice getById(int id) {
	 return invoiceRepository.findById(id).get();
	}

	@Override
	public Invoice create(Map<String, Object> invoice) {
		Invoice invoiceObject = new Invoice();

		String purchaserOrderId = invoice.get("poNumber").toString();
		PurchaseOrder purchaseOrder = purchaseOrderRepository.findById(Integer.parseInt(purchaserOrderId)).get();
		// System.out.println("purchaserOrder 0--->"+purchaseOrder);
		String clientId = invoice.get("name").toString();
		Client client = clientRepository.findById(Long.parseLong(clientId)).get();	
		System.out.println("client object --"+client.toString());
		ReflectionBeanUtil.mapClassFields(invoice, invoiceObject);
		invoiceObject.setEnabled(1);
		invoiceObject.setPurchaseOrder(purchaseOrder);
		invoiceObject.setClient(client);
		System.out.println("keyset -->" + invoice.keySet());
		System.out.println("invoice Items -->" + invoice.get("invoiceItems"));
		List<InvoiceItem> invoiceItemList = new ArrayList<>();
		List<Map<String, String>> invoiceItems = (List<Map<String, String>>) invoice.get("invoiceItems");
		System.out.println("invoiceItems --->" + invoiceItems);
		Invoice saveInvoice = invoiceRepository.save(invoiceObject);
		System.out.println("invoice object --->>." + invoiceObject);
		for (int i = 0; i < invoiceItems.size(); i++) {
			Map<String, String> items = invoiceItems.get(i);
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

	@Override
	public Invoice update(Map<String, Object> invoice, int id) {
		// TODO Auto-generated method stub
	  Invoice invoiceObject = invoiceRepository.findById(id).get();
	  String clientId = invoice.get("name").toString();
	  Client client = clientRepository.findById(Long.parseLong(clientId)).get();
	  invoiceObject.setClient(client);
	  String purchaserOrderId = invoice.get("poNumber").toString();
	  PurchaseOrder  purchaseOrder = purchaseOrderRepository.findById(Integer.parseInt(purchaserOrderId)).get();
	  invoiceObject.setPurchaseOrder(purchaseOrder);
	  ReflectionBeanUtil.mapClassFields(invoice, invoiceObject);
	  List<InvoiceItem> invoiceItemList = new ArrayList<>();
	  List<Map<String, String>> invoiceItems = (List<Map<String, String>>) invoice.get("invoiceItems");
	  Invoice updateInvoice = invoiceRepository.save(invoiceObject);
	  for (int i = 0; i < invoiceItems.size(); i++) {
			Map<String, String> items = invoiceItems.get(i);
			InvoiceItem invoiceItem = new InvoiceItem();
			invoiceItem.setQuantity(Integer.parseInt(items.get("qty").toString()));
			invoiceItem.setAmount(Double.parseDouble(items.get("amount").toString()));
			invoiceItem.setDescrition(items.get("description"));
			invoiceItem.setPart(Double.parseDouble(items.get("part")));
			invoiceItem.setInvoice(updateInvoice);
			invoiceItemList.add(invoiceItem);
			invoiceItemRepository.save(invoiceItem);
		}
		invoiceObject.setInvoiceItems(invoiceItemList);
		return updateInvoice;
	}

}
