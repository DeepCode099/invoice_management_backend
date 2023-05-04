package com.invoicemanagement.controller;

import java.util.HashMap;
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

import com.invoicemanagement.model.Client;
import com.invoicemanagement.service.ClientService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/client")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	@PostMapping
	public ResponseEntity<Client> addClient(@RequestBody Map<Object, Object>client) throws ClassNotFoundException{
		System.out.println("test");
		return new ResponseEntity<Client>(clientService.add(client), HttpStatus.CREATED);
		
	}
	

}
