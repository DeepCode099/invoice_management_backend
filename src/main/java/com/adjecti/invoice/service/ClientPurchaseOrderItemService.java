package com.adjecti.invoice.service;

import java.util.List;

import com.adjecti.invoice.model.ClientPurchaseOrderItem;

public interface ClientPurchaseOrderItemService {
	public ClientPurchaseOrderItem create(ClientPurchaseOrderItem clientPurchaseOrderItem);
	public List<ClientPurchaseOrderItem> getAll();
}
