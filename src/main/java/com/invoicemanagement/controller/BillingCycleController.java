package com.invoicemanagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invoicemanagement.model.BillingCycle;
import com.invoicemanagement.model.Currency;
import com.invoicemanagement.service.BillingCycleService;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/billingCycle")
public class BillingCycleController {

	
private BillingCycleService billingCycleService;
	
	public BillingCycleController(BillingCycleService billingCycleService) {
		super();
		this.billingCycleService = billingCycleService;
	}
	
	@PostMapping
	public ResponseEntity<BillingCycle> create(@RequestBody BillingCycle billingCycle){
		return new ResponseEntity<BillingCycle>(billingCycleService.create(billingCycle), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<BillingCycle> getAllBillingCycle() {
		return billingCycleService.getAll();
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteBillingCycle(@PathVariable("id") long billingCycleId) {
		// delete users from DB
		billingCycleService.delete(billingCycleId);
		return new ResponseEntity<String>("billingCycle deleted successfully!.", HttpStatus.OK);
	}
	@GetMapping("{id}")
	public ResponseEntity<BillingCycle> getById(@PathVariable("id") long id){
		return new ResponseEntity<BillingCycle>(billingCycleService.getById(id),HttpStatus.OK);
	}
	
	
	
}
