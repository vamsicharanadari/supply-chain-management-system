package com.adarivamsi.supply_chain_management_system.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderItemId;

    @ManyToOne
    @JoinColumn(name = "purchaseOrderId")
    private PurchaseOrder purchaseOrder;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    private Integer quantity;
    private Double unitPrice;

}
