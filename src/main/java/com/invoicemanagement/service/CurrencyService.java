package com.invoicemanagement.service;

import java.util.List;

import com.invoicemanagement.model.Currency;

public interface CurrencyService {
	public Currency create(Currency currency);
	
	public List<Currency> getAll();
}
