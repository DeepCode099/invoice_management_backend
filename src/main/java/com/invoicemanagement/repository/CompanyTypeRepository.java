package com.invoicemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invoicemanagement.model.CompanyType;

public interface CompanyTypeRepository extends JpaRepository<CompanyType, Long>{

}
