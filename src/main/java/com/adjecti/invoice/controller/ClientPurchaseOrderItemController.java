package com.adjecti.invoice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adjecti.invoice.model.ClientPurchaseOrderItem;
import com.adjecti.invoice.service.ClientPurchaseOrderItemService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/clientPurchaserOrderItem")
public class ClientPurchaseOrderItemController {

	@Autowired
	private ClientPurchaseOrderItemService clientPurchaseOrderItemService;
	
	    @PostMapping
		public ResponseEntity<ClientPurchaseOrderItem> addClientPurchaseOrderItem(@RequestBody ClientPurchaseOrderItem clientPurchaseOrderItem){
			System.out.println("test ClientPurchaseOrderItem");
			return new ResponseEntity<ClientPurchaseOrderItem>(clientPurchaseOrderItemService.create(clientPurchaseOrderItem), HttpStatus.CREATED);	
		}
	    @GetMapping
	    public List<ClientPurchaseOrderItem> getAll(){
	    	return clientPurchaseOrderItemService.getAll();
	    }

}
