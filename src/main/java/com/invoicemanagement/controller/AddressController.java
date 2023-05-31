package com.invoicemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invoicemanagement.model.Address;
import com.invoicemanagement.service.AddressService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/address")
public class AddressController {
	@Autowired
	private AddressService addressService;
	
	@PostMapping
	public ResponseEntity<Address> create(@RequestBody Address address){
		return new ResponseEntity<Address>(addressService.create(address), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Address> getAll() {
		return addressService.getAll(); 
		}
	}
