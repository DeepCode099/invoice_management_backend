package com.adjecti.invoice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adjecti.invoice.model.Currency;
import com.adjecti.invoice.service.CurrencyService;

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
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCurrency(@PathVariable("id") long currencyId) {
		// delete users from DB
		currencyService.delete(currencyId);
		return new ResponseEntity<String>("currency deleted successfully!.", HttpStatus.OK);
	}
	@PutMapping("{id}")
	public ResponseEntity<Currency> updateCurrency(@PathVariable("id") long id, @RequestBody Currency currency) {
		return new ResponseEntity<Currency>(currencyService.update(currency, id), HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<Currency> getById(@PathVariable("id") long id){
		System.out.println(id+"aa");
		return new ResponseEntity<Currency>(currencyService.getById(id),HttpStatus.OK);
	}
	
	
	
}
