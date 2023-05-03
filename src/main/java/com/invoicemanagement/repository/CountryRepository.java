package com.invoicemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invoicemanagement.model.Country;

public interface CountryRepository  extends JpaRepository<Country, Long>{

}
