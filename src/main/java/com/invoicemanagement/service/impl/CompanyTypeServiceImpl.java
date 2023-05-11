package com.invoicemanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoicemanagement.model.CompanyType;
import com.invoicemanagement.repository.CompanyTypeRepository;
import com.invoicemanagement.service.CompanyTypeService;

@Service
public class CompanyTypeServiceImpl implements CompanyTypeService {

	@Autowired
	private CompanyTypeRepository companyTypeRepository;
	
	@Override
	public CompanyType create(CompanyType companyType) {
		return companyTypeRepository.save(companyType);
	}

	@Override
	public List<CompanyType> getAll() {
		return companyTypeRepository.findAll();
	}

	@Override
	public CompanyType update(CompanyType companyType, long id) {
		CompanyType  companytype=companyTypeRepository.findById(id).get();
		if (companytype!=null) {
			companytype.setName(companyType.getName());
			}
		return companyTypeRepository.save(companytype);
	}

	@Override
	public void delete(long id) {
		companyTypeRepository.deleteById(id);
		
	}

}
