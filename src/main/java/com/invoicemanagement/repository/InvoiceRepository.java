package com.invoicemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invoicemanagement.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}
