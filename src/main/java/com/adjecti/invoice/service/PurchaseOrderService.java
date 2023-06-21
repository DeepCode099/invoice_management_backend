package com.adjecti.invoice.service;

import java.util.List;
import java.util.Map;

import com.adjecti.invoice.model.BillingType;
import com.adjecti.invoice.model.PurchaseOrder;

public interface PurchaseOrderService {
    
    public PurchaseOrder add(PurchaseOrder purchaseOrder);
	public List<PurchaseOrder> getAll();
	public void delete(int id); 
	public PurchaseOrder getById(int id);
	public PurchaseOrder update(Map<String, Object>map, int id);
	
}
