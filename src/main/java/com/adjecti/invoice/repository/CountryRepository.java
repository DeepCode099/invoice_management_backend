package com.adjecti.invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adjecti.invoice.model.Country;

public interface CountryRepository  extends JpaRepository<Country, Long>{

}
