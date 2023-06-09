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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adjecti.invoice.model.AddressType;
import com.adjecti.invoice.service.AddressTypeService;

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
	@GetMapping
	public List<AddressType> getByEnabled() {
		return addressTypService.findByEnabled();
	}
	@GetMapping("{id}")
	public ResponseEntity<AddressType> getById(@PathVariable ("id") long id){
		return new ResponseEntity<AddressType>(addressTypService.getById(id), HttpStatus.OK);
		
	}
	@PutMapping("{id}")
	public ResponseEntity<AddressType>update(@PathVariable ("id") long id ,@RequestBody AddressType addressType){
		return new ResponseEntity<AddressType>(addressTypService.update(addressType, id), HttpStatus.OK);	
	}
	@DeleteMapping()
	public ResponseEntity<String> delete(@RequestParam ("id") long id){
		addressTypService.delete(id);
		return new ResponseEntity<String>("deleted successfully!.", HttpStatus.OK);	
	}
	

	
}
