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

import com.invoicemanagement.model.PurchaseOrder;
import com.invoicemanagement.model.ReceivePayment;
import com.invoicemanagement.service.PurchaseOrderService;
import com.invoicemanagement.service.ReceivePaymentService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/receivePayment")
public class ReceivePaymentController {

	
	@Autowired
    private ReceivePaymentService receivePaymentService;
	
	@PostMapping
	public ResponseEntity<ReceivePayment> createReceivePayment(@RequestBody Map<Object, Object> receivePayment)
			throws ClassNotFoundException {
		System.out.println("Object -->"+receivePayment);
		return new ResponseEntity<ReceivePayment>(receivePaymentService.add(receivePayment),
				HttpStatus.CREATED);
	} 
	
	@GetMapping
	public List<ReceivePayment> getAllPurchaseOrder() {
		return receivePaymentService.getAll();
	}

}
