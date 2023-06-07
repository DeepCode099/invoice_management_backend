package com.adjecti.invoice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adjecti.invoice.model.Client;
import com.adjecti.invoice.model.Tax;

public interface TaxRepository extends JpaRepository<Tax, Long> {
	public List<Tax> findByClient(Client client);

}
