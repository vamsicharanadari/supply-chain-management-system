package com.adarivamsi.supply_chain_management_system.repository;

import com.adarivamsi.supply_chain_management_system.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
