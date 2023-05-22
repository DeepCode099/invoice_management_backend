package com.invoicemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invoicemanagement.model.Tax;

public interface TaxRepository extends JpaRepository<Tax, Long> {

}
