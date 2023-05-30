package com.invoicemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.invoicemanagement.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

	
	@Query(value = "Select * from tbl_invoice where enabled=1",nativeQuery = true)
	public List<Invoice> getAllByEnabled();
}
