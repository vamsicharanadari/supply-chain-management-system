package com.adarivamsi.supply_chain_management_system.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer supplierId;

    private String name;
    private String contactEmail;
    private String contactPhone;
    private Date createdAt;
    private Date updatedAt;

}
