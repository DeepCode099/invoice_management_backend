package com.adjecti.invoice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adjecti.invoice.model.CompanyType;
import com.adjecti.invoice.repository.CompanyTypeRepository;
import com.adjecti.invoice.service.CompanyTypeService;

@Service
public class CompanyTypeServiceImpl implements CompanyTypeService {

	@Autowired
	private CompanyTypeRepository companyTypeRepository;
	
	@Override
	public CompanyType create(CompanyType companyType) {
		return companyTypeRepository.save(companyType);
	}
	public List<CompanyType> saveAll(List<CompanyType> companyType) {
		return companyTypeRepository.saveAll(companyType);
	}

	@Override
	public List<CompanyType> getAll() {
		return companyTypeRepository.findAll();
	}
	@Override
	public CompanyType getById(long id) {
		return companyTypeRepository.findById(id).get();
	}

	@Override
	public CompanyType update(CompanyType companyType, long id) {
		CompanyType  companytype=companyTypeRepository.findById(id).get();
		if (companytype!=null) {
			companytype.setCname(companyType.getCname());
			}
		return companyTypeRepository.save(companytype);
	}

	@Override
	public void delete(long id) {
		companyTypeRepository.deleteById(id);
		
	}

}
