package com.invoicemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invoicemanagement.model.BillingType;

public interface BillingTypeRepository extends JpaRepository<BillingType, Long> {

}
