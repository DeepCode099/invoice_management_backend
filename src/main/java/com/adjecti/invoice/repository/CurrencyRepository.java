package com.adjecti.invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adjecti.invoice.model.Currency;

public interface CurrencyRepository  extends JpaRepository<Currency, Long>{

}
