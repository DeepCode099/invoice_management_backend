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

import com.adjecti.invoice.model.BillingCycle;
import com.adjecti.invoice.model.CompanyType;
import com.adjecti.invoice.model.Currency;
import com.adjecti.invoice.service.BillingCycleService;

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
	public ResponseEntity<BillingCycle> create(@RequestBody BillingCycle billingCycle) {
		return new ResponseEntity<BillingCycle>(billingCycleService.create(billingCycle), HttpStatus.CREATED);
	}

	@GetMapping
	public List<BillingCycle> getAllBillingCycle() {
		return billingCycleService.getAll();
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteBillingCycle(@PathVariable("id") long billingCycleId) {
		billingCycleService.delete(billingCycleId);
		return new ResponseEntity<String>("billingCycle deleted successfully!.", HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<BillingCycle> getById(@PathVariable("id") long id) {
		return new ResponseEntity<BillingCycle>(billingCycleService.getById(id), HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<BillingCycle> update(@PathVariable("id") long id, @RequestBody BillingCycle billingCycle) {
		return new ResponseEntity<BillingCycle>(billingCycleService.update(billingCycle, id), HttpStatus.OK);
	}

}
