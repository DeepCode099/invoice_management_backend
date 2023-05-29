package com.invoicemanagement.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoicemanagement.model.Client;
import com.invoicemanagement.model.Invoice;
import com.invoicemanagement.model.PaymentMode;
import com.invoicemanagement.model.PurchaseOrder;
import com.invoicemanagement.model.ReceivePayment;
import com.invoicemanagement.repository.ClientRepository;
import com.invoicemanagement.repository.InvoiceRepository;
import com.invoicemanagement.repository.PaymentModeRepository;
import com.invoicemanagement.repository.ReceivePaymentRepository;
import com.invoicemanagement.service.ReceivePaymentService;
import com.invoicemanagement.util.ReflectionBeanUtil;

@Service
public class ReceivePaymentServiceImpl implements ReceivePaymentService {

	
	
	@Autowired
	private ReceivePaymentRepository receivePaymentRepository;
	
	@Autowired 
	private InvoiceRepository invoiceRepository;
	
	@Autowired
	private PaymentModeRepository paymentModeRepository;
	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public ReceivePayment create(Map<String, Object> receivePayment) throws ClassNotFoundException {
		ReceivePayment receivePaymentObject = new ReceivePayment();
		
	String clientId= receivePayment.get("client").toString();
	Client client= clientRepository.findById(Long.parseLong(clientId)).get();
		System.out.println("keys -->"+receivePayment.keySet());
		String invoiceId = receivePayment.get("invoiceNo").toString();
		Invoice invoice  = invoiceRepository.findById(Integer.parseInt(invoiceId)).get();
		ReflectionBeanUtil.mapClassFields(receivePayment, receivePaymentObject);
		//ReflectionBeanUtil.mapClassFields(receivePayment, client);
		receivePaymentObject.setClient(client);
		receivePaymentObject.setInvoice(invoice);
		String paymentModeId = receivePayment.get("name").toString();
		PaymentMode paymentMode  = paymentModeRepository.findById(Long.parseLong(paymentModeId)).get();
		receivePaymentObject.setPaymentMode(paymentMode);
		return receivePaymentRepository.save(receivePaymentObject);
	}

	@Override
	public List<ReceivePayment> getAll() {
		return receivePaymentRepository.findAll();
	}

}
