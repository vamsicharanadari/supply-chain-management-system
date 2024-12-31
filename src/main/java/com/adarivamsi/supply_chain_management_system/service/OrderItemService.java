package com.adarivamsi.supply_chain_management_system.service;

import com.adarivamsi.supply_chain_management_system.model.OrderItem;
import com.adarivamsi.supply_chain_management_system.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    // Retrieve all order items
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    // Retrieve a specific order item by ID
    public Optional<OrderItem> getOrderItemById(Integer id) {
        return orderItemRepository.findById(id);
    }

    // Create a new order item
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    // Update an existing order item
    public OrderItem updateOrderItem(Integer id, OrderItem orderItemDetails) {
        Optional<OrderItem> optionalOrderItem = orderItemRepository.findById(id);
        if (optionalOrderItem.isPresent()) {
            OrderItem orderItem = optionalOrderItem.get();
            orderItem.setProduct(orderItemDetails.getProduct());
            orderItem.setPurchaseOrder(orderItemDetails.getPurchaseOrder());
            orderItem.setQuantity(orderItemDetails.getQuantity());
            orderItem.setUnitPrice(orderItemDetails.getUnitPrice());
            return orderItemRepository.save(orderItem);
        } else {
            throw new RuntimeException("OrderItem not found with ID: " + id);
        }
    }

    // Delete an order item by ID
    public void deleteOrderItem(Integer id) {
        orderItemRepository.deleteById(id);
    }

}
