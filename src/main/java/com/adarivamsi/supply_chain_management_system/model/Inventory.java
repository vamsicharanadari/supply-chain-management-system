package com.adarivamsi.supply_chain_management_system.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer inventoryId;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    private Integer quantityInStock;
    private Date lastUpdated;

}
