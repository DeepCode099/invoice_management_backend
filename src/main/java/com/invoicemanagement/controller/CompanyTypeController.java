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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.invoicemanagement.model.CompanyType;
import com.invoicemanagement.service.AddressTypeService;
import com.invoicemanagement.service.CompanyTypeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/companyType")

public class CompanyTypeController {
	
	private CompanyTypeService companyTypeService;
	public CompanyTypeController(CompanyTypeService companyTypeService) {
		super();
		this.companyTypeService = companyTypeService;
	}
		
		@PostMapping
		public ResponseEntity<CompanyType> createCompanyType(@RequestBody CompanyType companyType){
			return new ResponseEntity<CompanyType>(companyTypeService.create(companyType), HttpStatus.CREATED);
		}
		
		@GetMapping()
		public List<CompanyType> getAll() {
			return companyTypeService.getAll();
		}
		@GetMapping("{id}")
		public ResponseEntity<CompanyType> getById(@PathVariable ("id") long id) {
			return new ResponseEntity<CompanyType>(companyTypeService.getById(id),HttpStatus.OK);
		}
		@PutMapping("{id}")
		public ResponseEntity<CompanyType> update(@PathVariable ("id") long id ,@RequestBody CompanyType companyType){
			return new ResponseEntity<CompanyType>(companyTypeService.update(companyType, id), HttpStatus.OK);
		}
		@DeleteMapping
		public ResponseEntity<String> delete(@RequestParam ("id") long id){
			companyTypeService.delete(id);
			return new ResponseEntity<String>("deleted successfully!.", HttpStatus.OK);
			 
		}

}
