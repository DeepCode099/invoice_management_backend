package com.adjecti.invoice.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adjecti.invoice.model.Tax;
import com.adjecti.invoice.repository.TaxRepository;
import com.adjecti.invoice.service.TaxService;

@Service
public class TaxServiceImpl implements TaxService {
	@Autowired
	private TaxRepository taxRepository;
	@Override
	public Tax create(Tax tax) {
		return taxRepository.save(tax);
	}

	@Override
	public void delete(long id) {
	taxRepository.deleteById(id);
		
	}

	@Override
	public Tax update(Tax tax,long id) {
		Tax taxObject = taxRepository.findById(id).get();
		if(taxObject!=null) {
			taxObject.setName(tax.getName());
		}
		return taxRepository.save(taxObject);
	}

	@Override
	public List<Tax> getAll() {
		return taxRepository.findAll();
	}

	@Override
	public Tax getById(long id) {
		return taxRepository.findById(id).get();
	}

}
