package com.invoicemanagement.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoicemanagement.model.BillingCycle;
import com.invoicemanagement.model.BillingType;
import com.invoicemanagement.model.ClientPurchaseOrderItem;
import com.invoicemanagement.model.PurchaseOrder;
import com.invoicemanagement.repository.BillingCycleRepository;
import com.invoicemanagement.repository.BillingTypeRepository;
import com.invoicemanagement.repository.ClientPurchaseOrderItemRepository;
import com.invoicemanagement.repository.PurchaseOrderRepository;
import com.invoicemanagement.service.PurchaseOrderService;
import com.invoicemanagement.util.ReflectionBeanUtil;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
	
	@Autowired
	private PurchaseOrderRepository  purchaseOrderRepository;

	@Autowired
	private BillingCycleRepository billingCycleRepository;
	@Autowired
	private BillingTypeRepository billingTypeRepository;
	@Autowired
    private ClientPurchaseOrderItemRepository clientPurchaseOrderItemRepository;
	 

	@Override
	public PurchaseOrder createPurchaseOrder(Map<Object, Object> purchaseOrder) throws ClassNotFoundException {
		PurchaseOrder purchaseOrderObject = new PurchaseOrder();
		BillingCycle billingCycle = new BillingCycle();
		BillingType billingType = new BillingType();
		ClientPurchaseOrderItem clientPurchaseOrderItem	= new ClientPurchaseOrderItem();
	
		//List<ClientPurchaseOrderItem>abc=purchaseOrderObject.getClientPurchaseOrderItem();
		//List<ClientPurchaseOrderItem> clientPurchaseOrderItems 	= new ArrayList<ClientPurchaseOrderItem>();
		
		/*
		 * for(ClientPurchaseOrderItem clientPurchaseOrderItem : abc) {
		 * 
		 * System.out.println("before mapping client purchase Order item object"
		 * +clientPurchaseOrderItem); ReflectionBeanUtil.mapClassFields(purchaseOrder,
		 * clientPurchaseOrderItem);
		 * clientPurchaseOrderItemRepository.save(clientPurchaseOrderItem);
		 * 
		 * System.out.println("after mapping of each object "+clientPurchaseOrderItem);
		 * 
		 * //ReflectionBeanUtil.mapClassFields(purchaseOrder, purchaseOrderObject);
		 * 
		 * 
		 * }
		 */
		
		//ReflectionBeanUtil.mapClassFieldsFromList(purchaseOrder, clientPurchaseOrderItems);
		ReflectionBeanUtil.mapClassFields(purchaseOrder, billingCycle);
		ReflectionBeanUtil.mapClassFields(purchaseOrder, billingType);
		ReflectionBeanUtil.mapClassFields(purchaseOrder, clientPurchaseOrderItem);
		ReflectionBeanUtil.mapClassFields(purchaseOrder, purchaseOrderObject);
		billingCycleRepository.save(billingCycle);
		billingTypeRepository.save(billingType);
		clientPurchaseOrderItemRepository.save(clientPurchaseOrderItem);
		purchaseOrderObject.setBillingCycle(billingCycle);
		purchaseOrderObject.setBillingType(billingType);
	   purchaseOrderObject.setClientPurchaseOrderItem(clientPurchaseOrderItem);
		return purchaseOrderRepository.save(purchaseOrderObject);

	}


	@Override
	public List<PurchaseOrder> getAll() {
		return purchaseOrderRepository.findAll();
	}


	
	
	
}
