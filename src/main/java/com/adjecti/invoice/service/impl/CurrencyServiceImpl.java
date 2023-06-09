package com.adjecti.invoice.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adjecti.invoice.exception.ResourceNotFoundException;
import com.adjecti.invoice.model.Currency;
import com.adjecti.invoice.repository.BillingCycleRepository;
import com.adjecti.invoice.repository.CurrencyRepository;
import com.adjecti.invoice.service.CurrencyService;

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
	
	@Override
	public void delete(long id) {
		// check whether a user exist or not
		currencyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("currency", "Id", id));
		currencyRepository.deleteById(id);
	}
	
	@Override
	public Currency update(Currency currency, long id) {
		Currency existingCurrency = currencyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Currency", "Id", id));
		existingCurrency.setName(currency.getName());
		return currencyRepository.save(existingCurrency);
	}
	@Override
	public Currency getById(long id) {
		return currencyRepository.findById(id).get();
	}

	
	
	
	
}
