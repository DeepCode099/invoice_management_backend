package com.invoicemanagement.service;

import java.util.List;
import java.util.Map;

import com.invoicemanagement.model.Client;

public interface ClientService {
	public Client add(Map<String, Object> client)throws ClassNotFoundException;
	public List<Client> getAll();
	public Client update(Client client, long id);
	public void delete(long id); 

}
