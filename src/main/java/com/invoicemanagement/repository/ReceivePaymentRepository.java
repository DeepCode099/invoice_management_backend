package com.invoicemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invoicemanagement.model.ReceivePayment;

public interface ReceivePaymentRepository extends JpaRepository<ReceivePayment, Integer> {

}
