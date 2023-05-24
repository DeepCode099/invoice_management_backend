package com.invoicemanagement.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoicemanagement.model.ReceivePayment;
import com.invoicemanagement.repository.ReceivePaymentRepository;
import com.invoicemanagement.service.ReceivePaymentService;
import com.invoicemanagement.util.ReflectionBeanUtil;

@Service
public class ReceivePaymentServiceImpl implements ReceivePaymentService {

	
	
	@Autowired
	private ReceivePaymentRepository ReceivePaymentRepository;
	
	@Override
	public ReceivePayment add(Map<Object, Object> receivePayment) throws ClassNotFoundException {
		ReceivePayment receivePaymentObject = new ReceivePayment();
		//ReflectionBeanUtil.mapClassFields(receivePayment, receivePaymentObject);
		return ReceivePaymentRepository.save(receivePaymentObject);
	}

	@Override
	public List<ReceivePayment> getAll() {
		return ReceivePaymentRepository.findAll();
	}

}
