package com.adjecti.invoice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adjecti.invoice.model.Tax;
import com.adjecti.invoice.service.TaxService;
@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/tax")
public class TaxController {
	
	@Autowired
	private TaxService taxService;
	@PostMapping
	public ResponseEntity<Tax> create(@RequestBody Tax tax){
		return new ResponseEntity<Tax>(taxService.create(tax),HttpStatus.CREATED);
	}
	@DeleteMapping
	public ResponseEntity<String> delete(@RequestParam("id") long id){
		return new ResponseEntity<String>("deleted successfully!.", HttpStatus.OK);
	}
	@PutMapping("{id}")
	public ResponseEntity<Tax> update(@RequestParam("id") long id, @RequestBody Tax tax){
		return new ResponseEntity<Tax>(taxService.update(tax, id), HttpStatus.OK);
	}
	@GetMapping()
	public List<Tax> getAll(){
		return taxService.getAll();
	}
	
	
	

}
