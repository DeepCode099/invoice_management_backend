package com.invoicemanagement.service;

import java.util.List;
import java.util.Map;

import com.invoicemanagement.model.BillingType;
import com.invoicemanagement.model.PurchaseOrder;

public interface PurchaseOrderService {

    public PurchaseOrder createPurchaseOrder(Map<String, Object> purchaseOrder) throws ClassNotFoundException;

	public List<PurchaseOrder> getAll();
	public void delete(int id); 
	public PurchaseOrder getById(int id);
	public PurchaseOrder update(Map<String, Object>map, int id);
	
}
