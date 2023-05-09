package com.invoicemanagement.service.impl;

import org.springframework.stereotype.Service;

import com.invoicemanagement.model.PurchaseOrder;
import com.invoicemanagement.repository.PurchaseOrderRepository;
import com.invoicemanagement.service.PurchaseOrderService;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

	private PurchaseOrderRepository  purchaseOrderRepository;
	
	public PurchaseOrderServiceImpl(PurchaseOrderRepository purchaseOrderRepository) {
		super();
		this.purchaseOrderRepository = purchaseOrderRepository;
	}
	
	
	@Override
	public PurchaseOrder create(PurchaseOrder purchaseOrder) {
		return 	purchaseOrderRepository.save(purchaseOrder);
	}

}
