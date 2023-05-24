package com.invoicemanagement.controller;

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

import com.invoicemanagement.model.BillingCycle;
import com.invoicemanagement.model.BillingType;
import com.invoicemanagement.service.BillingTypeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/billingType")
public class BillingTypeController {

private BillingTypeService billingTypeService;
	
	public BillingTypeController(BillingTypeService billingTypeService) {
		super();
		this.billingTypeService = billingTypeService;
	}
	
	@PostMapping
	public ResponseEntity<BillingType> create(@RequestBody BillingType bllingType){
		return new ResponseEntity<BillingType>(billingTypeService.create(bllingType), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<BillingType> getAll() {
		return billingTypeService.getAll();
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable("id") long id) {
		// delete users from DB
		billingTypeService.delete(id);
		return new ResponseEntity<String>("BillingType deleted successfully!.", HttpStatus.OK);
	}
	@GetMapping("{id}")
	public ResponseEntity<BillingType> getById(@PathVariable("id") long id){
		return new ResponseEntity<BillingType>(billingTypeService.getById(id),HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<BillingType> update(@PathVariable("id") long id, @RequestBody BillingType billingType) {
		return new ResponseEntity<BillingType>(billingTypeService.update(billingType, id), HttpStatus.OK);
	}
	
}
