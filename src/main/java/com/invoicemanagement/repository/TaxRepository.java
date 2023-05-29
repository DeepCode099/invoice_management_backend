package com.invoicemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invoicemanagement.model.Client;
import com.invoicemanagement.model.Tax;

public interface TaxRepository extends JpaRepository<Tax, Long> {
	public List<Tax> findByClient(Client client);

}
