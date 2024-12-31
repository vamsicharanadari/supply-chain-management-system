package com.adarivamsi.supply_chain_management_system.service;

import com.adarivamsi.supply_chain_management_system.model.Inventory;
import com.adarivamsi.supply_chain_management_system.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    /**
     * Retrieve all inventory items.
     *
     * @return a list of all inventory items
     */
    public List<Inventory> getAllInventories() {
        return inventoryRepository.findAll();
    }

    /**
     * Retrieve a specific inventory item by ID.
     *
     * @param id the inventory ID
     * @return an optional containing the inventory item if found
     */
    public Optional<Inventory> getInventoryById(Integer id) {
        return inventoryRepository.findById(id);
    }

    /**
     * Add a new inventory item.
     *
     * @param inventory the inventory item to be added
     * @return the saved inventory item
     */
    public Inventory createInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    /**
     * Update an existing inventory item.
     *
     * @param id the inventory ID to be updated
     * @param updatedInventory the updated inventory details
     * @return the updated inventory item
     */
    public Inventory updateInventory(Integer id, Inventory updatedInventory) {
        return inventoryRepository.findById(id).map(inventory -> {
            inventory.setProduct(updatedInventory.getProduct());
            inventory.setQuantityInStock(updatedInventory.getQuantityInStock());
            inventory.setLastUpdated(updatedInventory.getLastUpdated());
            return inventoryRepository.save(inventory);
        }).orElseThrow(() -> new RuntimeException("Inventory not found with id " + id));
    }

    /**
     * Delete an inventory item by ID.
     *
     * @param id the inventory ID to be deleted
     */
    public void deleteInventory(Integer id) {
        inventoryRepository.deleteById(id);
    }

}
