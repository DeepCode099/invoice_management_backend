package com.adjecti.invoice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.adjecti.invoice.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

	
	@Query(value = "Select * from tbl_invoice where enabled=0",nativeQuery = true)
	public List<Invoice> getAllByEnabled();
}
