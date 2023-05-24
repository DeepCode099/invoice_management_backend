package com.invoicemanagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.invoicemanagement.model.ClientPurchaseOrderItem;
import com.invoicemanagement.model.PurchaseOrder;
import com.invoicemanagement.service.PurchaseOrderService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/purchaseOrder")
public class PurchaseOrderController {
	
	@Autowired
    private PurchaseOrderService purchaseOrderService;
	
	@PostMapping
	public ResponseEntity<PurchaseOrder> createPurchaseOrder(@RequestBody HashMap<String, Object> purchaseOrder)
			throws ClassNotFoundException {
		System.out.println("Object -->"+purchaseOrder);
		return new ResponseEntity<PurchaseOrder>(purchaseOrderService.createPurchaseOrder(purchaseOrder),
				HttpStatus.CREATED);
	} 
	
	@GetMapping
	public List<PurchaseOrder> getAllPurchaseOrder() {
		return purchaseOrderService.getAll();
	}

}
