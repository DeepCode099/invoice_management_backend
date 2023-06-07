package com.adjecti.invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adjecti.invoice.model.PaymentMode;

public interface PaymentModeRepository extends JpaRepository<PaymentMode,Long> {

}
