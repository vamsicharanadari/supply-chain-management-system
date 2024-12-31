package com.adarivamsi.supply_chain_management_system.repository;

import com.adarivamsi.supply_chain_management_system.model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Integer> {
}
