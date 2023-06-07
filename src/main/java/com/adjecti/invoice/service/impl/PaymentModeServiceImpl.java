package com.adjecti.invoice.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adjecti.invoice.exception.ResourceNotFoundException;
import com.adjecti.invoice.model.Currency;
import com.adjecti.invoice.model.PaymentMode;
import com.adjecti.invoice.repository.CurrencyRepository;
import com.adjecti.invoice.repository.PaymentModeRepository;
import com.adjecti.invoice.service.PaymentModeService;

@Service 
public class PaymentModeServiceImpl implements PaymentModeService {

	private PaymentModeRepository paymentModeRepository;

	public PaymentModeServiceImpl(PaymentModeRepository paymentModeRepository) {
		super();
		this.paymentModeRepository = paymentModeRepository;
	}

	@Override
	public PaymentMode create(PaymentMode paymentMode) {
		return paymentModeRepository.save(paymentMode);
	}

	@Override
	public List<PaymentMode> getAll() {
		return paymentModeRepository.findAll();
	}

	@Override
	public void delete(long id) {
		paymentModeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("paymentMode", "Id", id));
		paymentModeRepository.deleteById(id);
	}

	@Override
	public PaymentMode update(PaymentMode paymentMode, long id) {
		PaymentMode existingPaymentMode = paymentModeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("PaymentMode", "Id", id));
		existingPaymentMode.setName(paymentMode.getName());
		return paymentModeRepository.save(existingPaymentMode);
	}

	@Override
	public PaymentMode getById(long id) {
		return paymentModeRepository.findById(id).get();
	}
	
	
}
