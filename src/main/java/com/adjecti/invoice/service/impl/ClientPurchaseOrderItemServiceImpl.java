package com.adjecti.invoice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adjecti.invoice.model.ClientPurchaseOrderItem;
import com.adjecti.invoice.repository.BillingTypeRepository;
import com.adjecti.invoice.repository.ClientPurchaseOrderItemRepository;
import com.adjecti.invoice.service.ClientPurchaseOrderItemService;
@Service
public class ClientPurchaseOrderItemServiceImpl implements ClientPurchaseOrderItemService{

	@Autowired
	private ClientPurchaseOrderItemRepository clientPurchaseOrderItemRepository;

	public ClientPurchaseOrderItemServiceImpl(ClientPurchaseOrderItemRepository clientPurchaseOrderItemRepository) {
		super();
		this.clientPurchaseOrderItemRepository = clientPurchaseOrderItemRepository;
	}
	
	
	@Override
	public ClientPurchaseOrderItem create(ClientPurchaseOrderItem clientPurchaseOrderItem) {
		return clientPurchaseOrderItemRepository.save(clientPurchaseOrderItem);
	}


	@Override
	public List<ClientPurchaseOrderItem> getAll() {
		return clientPurchaseOrderItemRepository.findAll();
	}

}
