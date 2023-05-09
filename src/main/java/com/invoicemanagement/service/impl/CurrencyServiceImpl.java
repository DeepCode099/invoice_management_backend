package com.invoicemanagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.invoicemanagement.model.Currency;
import com.invoicemanagement.repository.BillingCycleRepository;
import com.invoicemanagement.repository.CurrencyRepository;
import com.invoicemanagement.service.CurrencyService;

@Service
public class CurrencyServiceImpl  implements CurrencyService{

	
	private CurrencyRepository currencyRepository;

	public CurrencyServiceImpl(CurrencyRepository currencyRepository) {
		super();
		this.currencyRepository = currencyRepository;
	}
	@Override
	public Currency create(Currency currency) {
		return currencyRepository.save(currency);
	}
	@Override
	public List<Currency> getAll() {
		return currencyRepository.findAll();
	}

	
	
	
}
