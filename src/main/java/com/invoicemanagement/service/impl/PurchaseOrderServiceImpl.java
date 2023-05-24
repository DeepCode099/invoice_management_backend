package com.invoicemanagement.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	private ClientPurchaseOrderItemRepository clientPurchaseOrderItemRepository;

	/*
	 * @Autowired private ClientRepository clientRepository;
	 */
	@Override
	public PurchaseOrder createPurchaseOrder(Map<String, Object> purchaseOrder) throws ClassNotFoundException {
		PurchaseOrder purchaseOrderObject = new PurchaseOrder();
		String billingTypeId = purchaseOrder.get("billingTypeName").toString();
		System.out.println("billingType Id--->" + billingTypeId);
		ReflectionBeanUtil.mapClassFields(purchaseOrder, purchaseOrderObject);
		BillingType billingType = billingTypeRepository.findById(Long.parseLong(billingTypeId)).get();
		String billingCycleId = purchaseOrder.get("billingCycleName").toString();
		BillingCycle billingCycle = billingCycleRepository.findById(Long.parseLong(billingCycleId)).get();
		purchaseOrderObject.setBillingCycle(billingCycle);
		purchaseOrderObject.setBillingType(billingType);
		purchaseOrder.get("clientPurchaseOrderItem");
		//List<ClientPurchaseOrderItem> clientPurchaseOrderItemList = new ArrayList<>();
		Object ob =  purchaseOrder.get("clientPurchaseOrderItem");
		System.out.println("object is here --->"+ob);
		List<ClientPurchaseOrderItem> objectList =(List<ClientPurchaseOrderItem>) purchaseOrder.get("clientPurchaseOrderItem");
		//clientPurchaseOrderItemList.get(0).getItemName();
			System.out.println("list is here--->"+objectList);
			
			System.out.println("keyset-->"+purchaseOrder.keySet());
			for(int i=0;i<objectList.size();i++) {
				String  itemName  =  purchaseOrder.get("itemName").toString();
				
			}
			
			
		JSONObject jsonObj = new JSONObject(objectList);
		/*
		 * String itemName=(String)jsonObj.get("itemName"); String
		 * itemDescription=(String)jsonObj.get("itemDescription"); int
		 * qty=(Integer)jsonObj.get("qty"); float amount = (float)jsonObj.get("qty");
		 * float price =(float)jsonObj.get(itemDescription);
		 */
		
		System.out.println("jsonObj--------"+jsonObj);
		
		//System.out.println("jjjj->"+clientPurchaseOrderItemList);
		String sow = purchaseOrder.get("sow").toString();
		boolean isSow = Boolean.parseBoolean(sow);
		System.out.println(isSow);
		if (isSow) {
			purchaseOrderObject.setSow(isSow);
		} else {
			purchaseOrderObject.setSow(false);
		}
	
		//purchaseOrderObject.setClientPurchaseOrderItem(clientPurchaseOrderItemList);
		return purchaseOrderRepository.save(purchaseOrderObject);

	}

	@Override
	public List<PurchaseOrder> getAll() {
		return purchaseOrderRepository.findAll();
	}
}