package com.invoicemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invoicemanagement.model.Currency;

public interface CurrencyRepository  extends JpaRepository<Currency, Long>{

}
