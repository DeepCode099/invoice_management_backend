package com.invoicemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invoicemanagement.model.PurchaseOrder;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {

}
