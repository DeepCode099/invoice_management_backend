package com.adjecti.invoice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

import com.adjecti.invoice.model.Invoice;
import com.adjecti.invoice.model.PaymentMode;
import com.adjecti.invoice.model.PurchaseOrder;
import com.adjecti.invoice.service.InvoiceService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/invoice")
public class InvoiceController {

	@Autowired
    private InvoiceService invoiceService;
	
	
	@PostMapping
	public ResponseEntity<Invoice> add(@RequestBody Invoice invoice){
		System.out.println("test invoice -->");
		return new ResponseEntity<Invoice>(invoiceService.add(invoice),HttpStatus.CREATED);
	}
	
	/*
	 * @PostMapping public ResponseEntity<Invoice> createInvoice(@RequestBody
	 * Map<String, Object> invoice) throws ClassNotFoundException{
	 * System.out.println("test"); return new
	 * ResponseEntity<Invoice>(invoiceService.create(invoice), HttpStatus.CREATED);
	 * 
	 * }
	 */
	
	@GetMapping
	public List<Invoice> getAllInvoice() {
		return invoiceService.getAll();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Invoice> getById(@PathVariable("id") int id) {
	return new ResponseEntity<Invoice>(invoiceService.getById(id),HttpStatus.OK);
	
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteInvoice(@PathVariable("id") int id){
		invoiceService.delete(id);
		return new ResponseEntity<String>("invoice deleted successfully !.",HttpStatus.OK);
		
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Invoice> update(@RequestBody Map<String,Object> invoice , @PathVariable("id") int id){
		return new ResponseEntity<Invoice>(invoiceService.update(invoice, id),HttpStatus.OK);
	}
	
	
	
}
