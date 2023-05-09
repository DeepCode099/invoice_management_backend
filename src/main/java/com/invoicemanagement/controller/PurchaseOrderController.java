package com.invoicemanagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invoicemanagement.model.PurchaseOrder;
import com.invoicemanagement.service.PurchaseOrderService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/purchaseOrder")
public class PurchaseOrderController {
	

    private PurchaseOrderService purchaseOrderService;
	
	public PurchaseOrderController(PurchaseOrderService purchaseOrderService) {
		super();
		this.purchaseOrderService = purchaseOrderService;
	}
	@PostMapping
	public ResponseEntity<PurchaseOrder> createPurchaseOrder(@RequestBody PurchaseOrder purchaseOrder){
		return new ResponseEntity<PurchaseOrder>(purchaseOrderService.create(purchaseOrder), HttpStatus.CREATED);
	}
	

}
