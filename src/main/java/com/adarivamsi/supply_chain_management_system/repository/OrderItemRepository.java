package com.adarivamsi.supply_chain_management_system.repository;

import com.adarivamsi.supply_chain_management_system.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}
