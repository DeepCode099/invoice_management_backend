package com.adjecti.invoice.service;

import java.util.List;

import com.adjecti.invoice.model.Currency;

public interface CurrencyService {
	public Currency create(Currency currency);
	public List<Currency> getAll();
	public void delete(long id); 
	public Currency update(Currency currency, long id);
	public Currency getById(long id);
}
