package com.adjecti.invoice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;

import com.adjecti.invoice.model.PurchaseOrder;
import com.adjecti.invoice.service.PurchaseOrderService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/purchaseOrder")
public class PurchaseOrderController {
	
	@Autowired
    private PurchaseOrderService purchaseOrderService;
	
	@PostMapping
	public ResponseEntity<PurchaseOrder> add(@RequestBody PurchaseOrder purchaserOrder){
		return new ResponseEntity<PurchaseOrder>(purchaseOrderService.add(purchaserOrder),
				HttpStatus.CREATED);
	} 
	@GetMapping
	public List<PurchaseOrder> getAllPurchaseOrder() {
		return purchaseOrderService.getAll();
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deletePurchaseOrder(@PathVariable("id") int id){
		purchaseOrderService.delete(id);
		return new ResponseEntity<String>("purchaseOrder deleted successfully !.",HttpStatus.OK);	
	}
	@GetMapping("{id}")
	public ResponseEntity<PurchaseOrder> getById(@PathVariable("id") int id) {
		return new ResponseEntity<PurchaseOrder>(purchaseOrderService.getById(id), HttpStatus.OK);
	}
	@PutMapping("{id}")
	public ResponseEntity<PurchaseOrder> update(@RequestBody Map<String, Object> purchaseOrder, @PathVariable("id") int id ){
		return new ResponseEntity<PurchaseOrder> (purchaseOrderService.update(purchaseOrder, id), HttpStatus.OK);
		
	}
	
}
