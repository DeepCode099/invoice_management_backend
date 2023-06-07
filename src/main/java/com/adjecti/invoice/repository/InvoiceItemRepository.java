package com.adjecti.invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adjecti.invoice.model.InvoiceItem;

public interface InvoiceItemRepository  extends JpaRepository<InvoiceItem, Integer>{

}
