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
	public List<ReceivePayment> getAll() {
		return receivePaymentRepository.findAll();
	}

	@Override
	public ReceivePayment add(ReceivePayment receivePayment) {
		return receivePaymentRepository.save(receivePayment);
	}

}
