package com.adjecti.invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adjecti.invoice.model.BillingType;

public interface BillingTypeRepository extends JpaRepository<BillingType, Long> {

}
