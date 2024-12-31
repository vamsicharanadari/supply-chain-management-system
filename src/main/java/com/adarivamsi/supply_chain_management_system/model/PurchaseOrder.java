package com.adarivamsi.supply_chain_management_system.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer purchaseOrderId;

    @ManyToOne
    @JoinColumn(name = "supplierId")
    private Supplier supplier;

    private String status;
    private Double totalAmount;
    private Date orderDate;
    private Date createdAt;
    private Date updatedAt;

}
