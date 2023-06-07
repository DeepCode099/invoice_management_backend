package com.adjecti.invoice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adjecti.invoice.model.Address;
import com.adjecti.invoice.service.AddressService;

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
	
	@GetMapping("{id}")
	public ResponseEntity<Address> getById(@PathVariable("id") long id) {
		return new ResponseEntity<Address>(addressService.getById(id),HttpStatus.OK);

	}

	/*
	 * @PutMapping("{id}") public ResponseEntity<AddressType>
	 * update(@PathVariable("id") long id, @RequestBody AddressType addressType) {
	 * return new ResponseEntity<AddressType>(addressTypService.update(addressType,
	 * id), HttpStatus.OK); }
	 * 
	 * @DeleteMapping() public ResponseEntity<String> delete(@RequestParam("id")
	 * long id) { addressTypService.delete(id); return new
	 * ResponseEntity<String>("deleted successfully!.", HttpStatus.OK); }
	 */

	
	
	
	}
