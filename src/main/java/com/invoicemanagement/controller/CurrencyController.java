package com.invoicemanagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invoicemanagement.model.Currency;
import com.invoicemanagement.service.CurrencyService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/currency")
public class CurrencyController {

private CurrencyService currencyService;
	
	public CurrencyController(CurrencyService currencyService) {
		super();
		this.currencyService = currencyService;
	}
	
	@PostMapping
	public ResponseEntity<Currency> create(@RequestBody Currency currency){
		return new ResponseEntity<Currency>(currencyService.create(currency), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Currency> getAll() {
		return currencyService.getAll();
	}
}
