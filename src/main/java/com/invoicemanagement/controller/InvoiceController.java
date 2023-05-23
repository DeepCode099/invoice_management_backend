package com.invoicemanagement.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invoicemanagement.model.Invoice;
import com.invoicemanagement.service.InvoiceService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/invoice")
public class InvoiceController {

	@Autowired
    private InvoiceService invoiceService;
	
	@PostMapping
	public ResponseEntity<Invoice> createInvoice(@RequestBody Map<String, Object> invoice) throws ClassNotFoundException{
		System.out.println("test");
		return new ResponseEntity<Invoice>(invoiceService.create(invoice), HttpStatus.CREATED);
		
	}
	
	@GetMapping
	public List<Invoice> getAllInvoice() {
		return invoiceService.getAll();
	}
	
	
}
