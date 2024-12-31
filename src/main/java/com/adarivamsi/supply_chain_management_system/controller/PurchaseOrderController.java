package com.adarivamsi.supply_chain_management_system.controller;

import com.adarivamsi.supply_chain_management_system.model.PurchaseOrder;
import com.adarivamsi.supply_chain_management_system.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/purchaseOrders")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @GetMapping
    public List<PurchaseOrder> getAllOrders() {
        return purchaseOrderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Optional<PurchaseOrder> getOrderById(@PathVariable Integer id) {
        return purchaseOrderService.getOrderById(id);
    }

    @PostMapping
    public PurchaseOrder createPurchaseOrder(@RequestBody PurchaseOrder purchaseOrder) {
        return purchaseOrderService.createPurchaseOrder(purchaseOrder);
    }

    @PutMapping("/{id}")
    public PurchaseOrder updateProduct(@PathVariable Integer id, @RequestBody PurchaseOrder purchaseOrder) {
        return purchaseOrderService.updatePurchaseOrder(id, purchaseOrder);
    }

    @DeleteMapping("/{id}")
    public void deletePurchaseOrder(@PathVariable Integer id) {
        purchaseOrderService.deletePurchaseOrder(id);
    }
}
