package com.invoicemanagement.service;

import java.util.List;
import java.util.Map;

import com.invoicemanagement.model.PurchaseOrder;

public interface PurchaseOrderService {
	
	public PurchaseOrder createPurchaseOrder(Map<Object, Object> purchaseOrder )throws ClassNotFoundException;
	
	public List<PurchaseOrder> getAll();
}
