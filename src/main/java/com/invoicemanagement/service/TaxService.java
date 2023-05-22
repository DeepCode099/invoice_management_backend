package com.invoicemanagement.service;
import java.util.List;
import com.invoicemanagement.model.Tax;

public interface TaxService {
	
	public Tax create(Tax tax); 
	public void delete(long id);
	public Tax update(Tax tax, long id);
	public List<Tax> getAll ();
	public Tax getById(long id);
}
