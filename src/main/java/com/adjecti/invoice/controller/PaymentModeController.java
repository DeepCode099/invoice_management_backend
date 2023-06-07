package com.adjecti.invoice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
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

import com.adjecti.invoice.model.BillingType;
import com.adjecti.invoice.model.Currency;
import com.adjecti.invoice.model.PaymentMode;
import com.adjecti.invoice.service.CurrencyService;
import com.adjecti.invoice.service.PaymentModeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/paymentMode")
public class PaymentModeController {

	private PaymentModeService paymentModeService;

	public PaymentModeController(PaymentModeService paymentModeService) {
		super();
		this.paymentModeService = paymentModeService;
	}

	@PostMapping
	public ResponseEntity<PaymentMode> create(@RequestBody PaymentMode paymentMode) {
		return new ResponseEntity<PaymentMode>(paymentModeService.create(paymentMode), HttpStatus.CREATED);
	}
	@GetMapping
	public List<PaymentMode> getAll(){
		return paymentModeService.getAll();
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable("id") long id) {
		// delete users from DB
		paymentModeService.delete(id);
		return new ResponseEntity<String>("PaymentMode deleted successfully!.", HttpStatus.OK);
	}
	@GetMapping("{id}")
	public ResponseEntity<PaymentMode> getById(@PathVariable("id") long id){
		return new ResponseEntity<PaymentMode>(paymentModeService.getById(id),HttpStatus.OK);
	}
	@PutMapping("{id}")
	public ResponseEntity<PaymentMode> update(@PathVariable("id") long id, @RequestBody PaymentMode paymentMode) {
		return new ResponseEntity<PaymentMode>(paymentModeService.update(paymentMode, id), HttpStatus.OK);
	}
	
}
