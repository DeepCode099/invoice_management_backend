package com.invoicemanagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	@GetMapping()
	public List<AddressType> getAll() {
		return addressTypService.getAll();
	}
	@PutMapping()
	public ResponseEntity<AddressType>update(@RequestParam ("id") long id ,@RequestBody AddressType addressType){
		return new ResponseEntity<AddressType>(addressTypService.update(addressType, id), HttpStatus.OK);	
	}
	@DeleteMapping()
	public ResponseEntity<String> delete(@RequestParam ("id") long id){
		addressTypService.delete(id);
		return new ResponseEntity<String>("deleted successfully!.", HttpStatus.OK);	
	}
	

	
}
