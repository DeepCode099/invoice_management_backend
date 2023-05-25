package com.invoicemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invoicemanagement.model.InvoiceItem;

public interface InvoiceItemRepository  extends JpaRepository<InvoiceItem, Integer>{

}
