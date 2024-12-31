package com.adarivamsi.supply_chain_management_system.service;

import com.adarivamsi.supply_chain_management_system.model.Product;
import com.adarivamsi.supply_chain_management_system.model.PurchaseOrder;
import com.adarivamsi.supply_chain_management_system.repository.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseOrderService {

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    public List<PurchaseOrder> getAllOrders() {
        return purchaseOrderRepository.findAll();
    }

    public Optional<PurchaseOrder> getOrderById(Integer id) {
        return purchaseOrderRepository.findById(id);
    }

    public PurchaseOrder createPurchaseOrder(PurchaseOrder purchaseOrder) {
        return purchaseOrderRepository.save(purchaseOrder);
    }

    public PurchaseOrder updatePurchaseOrder(Integer id, PurchaseOrder purchaseOrder) {
        Optional<PurchaseOrder> existingPurchaseOrder = purchaseOrderRepository.findById(id);
        if(existingPurchaseOrder.isPresent()) {
            PurchaseOrder purchaseOrderNew = existingPurchaseOrder.get();
            purchaseOrderNew.setStatus(purchaseOrder.getStatus());
            purchaseOrderNew.setUpdatedAt(new Date());
            return purchaseOrderRepository.save(purchaseOrderNew);
        }
        return null;
    }

    public void deletePurchaseOrder(Integer id) {
        purchaseOrderRepository.deleteById(id);
    }
}
