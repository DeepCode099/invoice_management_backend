package com.adjecti.invoice.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adjecti.invoice.model.Client;
import com.adjecti.invoice.model.Invoice;
import com.adjecti.invoice.model.PaymentMode;
import com.adjecti.invoice.model.ReceivePayment;
import com.adjecti.invoice.repository.ClientRepository;
import com.adjecti.invoice.repository.InvoiceRepository;
import com.adjecti.invoice.repository.PaymentModeRepository;
import com.adjecti.invoice.repository.ReceivePaymentRepository;
import com.adjecti.invoice.service.ReceivePaymentService;
import com.adjecti.invoice.util.ReflectionBeanUtil;

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
		String clientId = receivePayment.get("client").toString();
		Client client = clientRepository.findById(Long.parseLong(clientId)).get();
		String invoiceId = receivePayment.get("invoiceNo").toString();
		Invoice invoice = invoiceRepository.findById(Integer.parseInt(invoiceId)).get();
		String paymentModeId = receivePayment.get("name").toString();
		PaymentMode paymentMode = paymentModeRepository.findById(Long.parseLong(paymentModeId)).get();
		ReflectionBeanUtil.mapClassFields(receivePayment, receivePaymentObject);
		receivePaymentObject.setClient(client);
		receivePaymentObject.setInvoice(invoice);
		receivePaymentObject.setPaymentMode(paymentMode);
		return receivePaymentRepository.save(receivePaymentObject);
	}

	@Override
	public List<ReceivePayment> getAll() {
		return receivePaymentRepository.findAll();
	}

}
