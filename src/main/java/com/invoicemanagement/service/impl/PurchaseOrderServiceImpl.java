package com.invoicemanagement.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoicemanagement.exception.ResourceNotFoundException;
import com.invoicemanagement.model.BillingCycle;
import com.invoicemanagement.model.BillingType;
import com.invoicemanagement.model.Client;
import com.invoicemanagement.model.ClientPurchaseOrderItem;
import com.invoicemanagement.model.PurchaseOrder;
import com.invoicemanagement.model.Tax;
import com.invoicemanagement.repository.BillingCycleRepository;
import com.invoicemanagement.repository.BillingTypeRepository;
import com.invoicemanagement.repository.ClientPurchaseOrderItemRepository;
import com.invoicemanagement.repository.ClientRepository;
import com.invoicemanagement.repository.PurchaseOrderRepository;
import com.invoicemanagement.service.PurchaseOrderService;
import com.invoicemanagement.util.ReflectionBeanUtil;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;

	@Autowired
	private BillingCycleRepository billingCycleRepository;

	@Autowired
	private BillingTypeRepository billingTypeRepository;
	
	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private ClientPurchaseOrderItemRepository clientPurchaseOrderItemRepository;

	@Override
	public PurchaseOrder createPurchaseOrder(Map<String, Object> purchaseOrder) throws ClassNotFoundException {
		PurchaseOrder purchaseOrderObject = new PurchaseOrder();
		String billingTypeId = purchaseOrder.get("billingTypeName").toString();
		ReflectionBeanUtil.mapClassFields(purchaseOrder, purchaseOrderObject);
		BillingType billingType = billingTypeRepository.findById(Long.parseLong(billingTypeId)).get();
		String billingCycleId = purchaseOrder.get("billingCycleName").toString();
		BillingCycle billingCycle = billingCycleRepository.findById(Long.parseLong(billingCycleId)).get();
		String clientId = purchaseOrder.get("client").toString();
		
    	System.out.println("clinet Id --->"+clientId);
		
		Client client = clientRepository.findById(Long.parseLong(clientId)).get();
	    System.out.println("Client object in impl "+client.getName());
	    purchaseOrderObject.setEnabled(1);
		purchaseOrderObject.setClient(client);
		purchaseOrderObject.setBillingCycle(billingCycle);
		purchaseOrderObject.setBillingType(billingType);
	//	purchaseOrder.get("clientPurchaseOrderItem");
		String sow = purchaseOrder.get("sow").toString();
		boolean isSow = Boolean.parseBoolean(sow);
		System.out.println(isSow);
		if (isSow) {
			purchaseOrderObject.setSow(isSow);
		} else {
			purchaseOrderObject.setSow(false);
		}
		System.out.println(purchaseOrder.get("clientPurchaseOrderItem"));
		List<ClientPurchaseOrderItem> clientpol = new ArrayList<>();
		List<Map<String, String>> clientPurchaseOrderItemList = (List<Map<String, String>>)purchaseOrder.get("clientPurchaseOrderItem");
		//System.out.println(clientPurchaseOrderItemList.size());
		PurchaseOrder savePO = purchaseOrderRepository.save(purchaseOrderObject);
		for (int i = 0; i < clientPurchaseOrderItemList.size(); i++) {
			Map<String, String> items = clientPurchaseOrderItemList.get(i);
			ClientPurchaseOrderItem clientPurchaseOrderItem = new ClientPurchaseOrderItem();
			clientPurchaseOrderItem.setItemName(items.get("itemName"));
			clientPurchaseOrderItem.setItemDescription((items.get("itemDescription")));
			clientPurchaseOrderItem.setQty(Integer.parseInt(items.get("qty").toString()));
			clientPurchaseOrderItem.setPrice(Float.parseFloat(items.get("price").toString()));
			clientPurchaseOrderItem.setAmount(Float.parseFloat(items.get("amount").toString()));
			clientPurchaseOrderItem.setPurchaseOrder(savePO);
			clientpol.add(clientPurchaseOrderItem);
			clientPurchaseOrderItemRepository.save(clientPurchaseOrderItem);
		}
		purchaseOrderObject.setClientPurchaseOrderItem(clientpol);
		return savePO;
	}

	@Override
	public List<PurchaseOrder> getAll() {
		return purchaseOrderRepository.getAllByEnabled();
	}

	@Override
	public void delete(int id) {
		
		PurchaseOrder purcahseOrder = purchaseOrderRepository.findById(id).get();
		purcahseOrder.setEnabled(0);
		
		purchaseOrderRepository.save(purcahseOrder);
		/*
		 * // check whether a user exist or not purchaseOrderRepository.findById(id)
		 * .orElseThrow(() -> new ResourceNotFoundException("PurchaseOrder", "Id", id));
		 * purchaseOrderRepository.deleteById(id);
		 */	}

	@Override
	public PurchaseOrder getById(int id) {
		return purchaseOrderRepository.findById(id).get();
	}
}