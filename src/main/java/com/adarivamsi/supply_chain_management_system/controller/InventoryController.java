package com.adarivamsi.supply_chain_management_system.controller;

import com.adarivamsi.supply_chain_management_system.model.Inventory;
import com.adarivamsi.supply_chain_management_system.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inventories")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public List<Inventory> getAllInventories() {
        return inventoryService.getAllInventories();
    }

    @GetMapping("/{id}")
    public Optional<Inventory> getInventoryById(@PathVariable Integer id) {
        return inventoryService.getInventoryById(id);
    }

    @PostMapping
    public Inventory createInventory(@RequestBody Inventory inventory) {
        return inventoryService.createInventory(inventory);
    }

    @PutMapping("/{id}")
    public Inventory updateInventory(@PathVariable Integer id, @RequestBody Inventory inventory) {
        return inventoryService.updateInventory(id, inventory);
    }

    @DeleteMapping("/{id}")
    public void deleteInventory(@PathVariable Integer id) {
        inventoryService.deleteInventory(id);
    }

}
