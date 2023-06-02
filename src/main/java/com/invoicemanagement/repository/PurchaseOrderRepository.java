package com.invoicemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.invoicemanagement.model.PurchaseOrder;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Integer> {

	@Query(value = "Select * from purchase_order where enabled=0",nativeQuery = true)
	public List<PurchaseOrder> getAllByEnabled();
	
}
