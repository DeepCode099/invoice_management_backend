package com.adjecti.invoice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adjecti.invoice.model.BillingCycle;
import com.adjecti.invoice.model.BillingType;
import com.adjecti.invoice.model.Client;
import com.adjecti.invoice.model.ClientPurchaseOrderItem;
import com.adjecti.invoice.model.PurchaseOrder;
import com.adjecti.invoice.repository.BillingCycleRepository;
import com.adjecti.invoice.repository.BillingTypeRepository;
import com.adjecti.invoice.repository.ClientPurchaseOrderItemRepository;
import com.adjecti.invoice.repository.ClientRepository;
import com.adjecti.invoice.repository.PurchaseOrderRepository;
import com.adjecti.invoice.service.PurchaseOrderService;
import com.adjecti.invoice.util.ReflectionBeanUtil;

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
	public List<PurchaseOrder> getAll() {
		return purchaseOrderRepository.getAllByEnabled();
	}

	@Override
	public void delete(int id) {
		PurchaseOrder purcahseOrder = purchaseOrderRepository.findById(id).get();
		if (purcahseOrder != null) {
			purcahseOrder.setEnabled(1);
			purchaseOrderRepository.save(purcahseOrder);
		}
	}

	@Override
	public PurchaseOrder getById(int id) {
		PurchaseOrder purchaseOrder = purchaseOrderRepository.findById(id).get();
		return purchaseOrderRepository.findById(id).get();
	}

	@Override
	public PurchaseOrder update(Map<String, Object> purchaseOrder, int id) {
		PurchaseOrder purchaseOrderObj = purchaseOrderRepository.findById(id).get();
		System.out.println(purchaseOrderObj);
		List<ClientPurchaseOrderItem> clientpol = new ArrayList<>();
		if (purchaseOrderObj != null) {
			ReflectionBeanUtil.mapClassFields(purchaseOrder, purchaseOrderObj);
			BillingType billingType = purchaseOrderObj.getBillingType();
			if (billingType != null) {
				String billingTypeId = purchaseOrder.get("billingTypeName").toString();
				billingType = billingTypeRepository.findById(Long.parseLong(billingTypeId)).get();
				System.out.println("billity" + billingType.getId());
				purchaseOrderObj.setBillingType(billingType);
			}
			BillingCycle billingCycle = purchaseOrderObj.getBillingCycle();
			if (billingCycle != null) {
				String billingCycleId = purchaseOrder.get("billingCycleName").toString();
				billingCycle = billingCycleRepository.findById(Long.parseLong(billingCycleId)).get();
				System.out.println("billc" + billingCycle.getId());
				purchaseOrderObj.setBillingCycle(billingCycle);
			}
			Client client = purchaseOrderObj.getClient();
			if (client != null) {
				String clientId = purchaseOrder.get("client").toString();
				System.out.println("clinet Id --->" + clientId);
				client = clientRepository.findById(Long.parseLong(clientId)).get();
				purchaseOrderObj.setClient(client);

			}
			String sow = purchaseOrder.get("sow").toString();
			boolean isSow = Boolean.parseBoolean(sow);
			System.out.println(isSow);
			if (isSow) {
				purchaseOrderObj.setSow(isSow);
			} else {
				purchaseOrderObj.setSow(false);
			}
			List<Map<String, String>> clientPurchaseOrderItemList = (List<Map<String, String>>) purchaseOrder
					.get("clientPurchaseOrderItem");
			List<ClientPurchaseOrderItem> clientPurchaseOrderItem2 = purchaseOrderObj.getClientPurchaseOrderItem();
			purchaseOrderObj = purchaseOrderRepository.save(purchaseOrderObj);
			for (int i = 0; i < clientPurchaseOrderItemList.size(); i++) {
				for (ClientPurchaseOrderItem clientPurchaseOrderItem : clientPurchaseOrderItem2) {
					Map<String, String> items = clientPurchaseOrderItemList.get(i);
					clientPurchaseOrderItem.setItemName(items.get("itemName"));
					clientPurchaseOrderItem.setItemDescription((items.get("itemDescription")));
					clientPurchaseOrderItem.setQty(Integer.parseInt(items.get("qty").toString()));
					clientPurchaseOrderItem.setPrice(Float.parseFloat(items.get("price").toString()));
					clientPurchaseOrderItem.setAmount(Float.parseFloat(items.get("amount").toString()));
					clientPurchaseOrderItem.setPurchaseOrder(purchaseOrderObj);
					clientpol.add(clientPurchaseOrderItem);
					clientPurchaseOrderItemRepository.save(clientPurchaseOrderItem);
				}
			}
		}
		purchaseOrderObj.setClientPurchaseOrderItem(clientpol);
		return purchaseOrderObj;
	}

	@Override
	public PurchaseOrder add(PurchaseOrder purchaseOrder) {
		return purchaseOrderRepository.save(purchaseOrder);
	}
}