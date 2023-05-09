package com.invoicemanagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invoicemanagement.model.BillingCycle;
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
	
}
