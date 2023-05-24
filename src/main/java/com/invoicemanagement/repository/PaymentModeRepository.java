package com.invoicemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invoicemanagement.model.PaymentMode;

public interface PaymentModeRepository extends JpaRepository<PaymentMode,Long> {

}
