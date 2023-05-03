package com.invoicemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invoicemanagement.model.BillingCycle;

public interface BillingCycleRepository extends JpaRepository<BillingCycle, Long> {

}
