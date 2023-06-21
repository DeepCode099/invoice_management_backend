package com.adjecti.invoice.controller;

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

import com.adjecti.invoice.model.PurchaseOrder;
import com.adjecti.invoice.model.ReceivePayment;
import com.adjecti.invoice.service.PurchaseOrderService;
import com.adjecti.invoice.service.ReceivePaymentService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/receivePayment")
public class ReceivePaymentController {
	
	@Autowired
    private ReceivePaymentService receivePaymentService;

	@GetMapping
	public List<ReceivePayment> getAllPurchaseOrder() {
		return receivePaymentService.getAll();
	}
	@PostMapping
	public ResponseEntity<ReceivePayment> add(@RequestBody ReceivePayment receivePayment){
		return new ResponseEntity<ReceivePayment>(receivePaymentService.add(receivePayment), HttpStatus.CREATED);
	}
}
