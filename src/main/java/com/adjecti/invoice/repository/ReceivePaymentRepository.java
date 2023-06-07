package com.adjecti.invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adjecti.invoice.model.ReceivePayment;

public interface ReceivePaymentRepository extends JpaRepository<ReceivePayment, Integer> {

}
