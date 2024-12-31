package com.adarivamsi.supply_chain_management_system.repository;

import com.adarivamsi.supply_chain_management_system.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
}
