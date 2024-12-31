package com.adarivamsi.supply_chain_management_system.model;

import jakarta.persistence.*;
import java.util.Date;
import lombok.Data;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    private String name;
    private String description;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "supplierId")
    private Supplier supplier;

    private Integer quantity;
    private Date created;
    private Date updated;

}
