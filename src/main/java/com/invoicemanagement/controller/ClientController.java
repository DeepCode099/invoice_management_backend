package com.invoicemanagement.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<Client> addClient(@RequestBody Map<String, Object>client) throws ClassNotFoundException{
		System.out.println("test");
		return new ResponseEntity<Client>(clientService.add(client), HttpStatus.CREATED);
		
	}
	@GetMapping
	public List<Client>getAll(){
		return clientService.getAll();
	}
	
	@DeleteMapping
	public ResponseEntity<String> delete(@RequestParam ("id") long id) {
		 clientService.delete(id);
		return new ResponseEntity<String>("deleted successfully!.", HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Client> getById(@PathVariable("id") long id){
		return new ResponseEntity<Client>(clientService.getById(id),HttpStatus.OK);
		
	}
	

}
