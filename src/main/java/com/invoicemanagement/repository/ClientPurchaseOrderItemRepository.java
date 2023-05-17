package com.invoicemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invoicemanagement.model.ClientPurchaseOrderItem;

public interface ClientPurchaseOrderItemRepository extends JpaRepository<ClientPurchaseOrderItem, Integer> {

}
