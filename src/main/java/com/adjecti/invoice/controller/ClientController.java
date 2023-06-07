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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adjecti.invoice.model.AddressType;
import com.adjecti.invoice.model.Client;
import com.adjecti.invoice.service.ClientService;

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
	public List<Client>getByEnabled(){
		return clientService.getAll();
	}
	@GetMapping("{id}")
	public ResponseEntity<Client> getById(@PathVariable ("id") long id){
		return new ResponseEntity<Client>(clientService.getById(id), HttpStatus.OK);
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable ("id") long id) {
		System.out.println("delete client");
		 clientService.delete(id);
		return new ResponseEntity<String>("deleted successfully!.", HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Client> update(@RequestBody Map<String, Object>client, @PathVariable long id) throws ClassNotFoundException{
		System.out.println("test");
		return new ResponseEntity<Client>(clientService.update(client, id), HttpStatus.CREATED);
		
	}
	

}
