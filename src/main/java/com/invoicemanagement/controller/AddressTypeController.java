package com.invoicemanagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.invoicemanagement.model.AddressType;
import com.invoicemanagement.service.AddressTypeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/addressType")
public class AddressTypeController {

private AddressTypeService addressTypService;
	
	public AddressTypeController(AddressTypeService addressTypeService) {
		super();
		this.addressTypService = addressTypeService;
	}
	@PostMapping
	public ResponseEntity<AddressType> createAddressType(@RequestBody AddressType addressType){
		return new ResponseEntity<AddressType>(addressTypService.create(addressType), HttpStatus.CREATED);
	}
	
}
