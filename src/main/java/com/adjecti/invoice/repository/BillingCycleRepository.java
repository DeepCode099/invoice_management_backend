package com.adjecti.invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adjecti.invoice.model.BillingCycle;

public interface BillingCycleRepository extends JpaRepository<BillingCycle, Long> {

}
