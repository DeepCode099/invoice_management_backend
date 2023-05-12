package com.invoicemanagement.service;

import java.util.List;

import com.invoicemanagement.model.CompanyType;

public interface CompanyTypeService {
	public CompanyType create(CompanyType companyType);
	public List<CompanyType> getAll();
	public CompanyType getById(long id) ;
	public CompanyType update(CompanyType companyType, long id);
	public void delete(long id); 
}
