package com.adjecti.invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adjecti.invoice.model.ClientPurchaseOrderItem;

public interface ClientPurchaseOrderItemRepository extends JpaRepository<ClientPurchaseOrderItem, Integer> {

}
