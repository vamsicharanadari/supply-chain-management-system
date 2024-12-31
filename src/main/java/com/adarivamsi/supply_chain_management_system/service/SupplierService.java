package com.adarivamsi.supply_chain_management_system.service;

import com.adarivamsi.supply_chain_management_system.model.Supplier;
import com.adarivamsi.supply_chain_management_system.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Optional<Supplier> getSupplierById(Integer id) {
        return supplierRepository.findById(id);
    }

    public Supplier createSupplier(Supplier supplier) {
        supplier.setCreatedAt(new Date());
        supplier.setUpdatedAt(new Date());
        return supplierRepository.save(supplier);
    }

    public Supplier updateSupplier(Integer id, Supplier supplier) {
        return supplierRepository.findById(id)
                .map(existingSupplier -> {
                    existingSupplier.setName(supplier.getName());
                    existingSupplier.setContactEmail(supplier.getContactEmail());
                    existingSupplier.setContactPhone(supplier.getContactPhone());
                    existingSupplier.setUpdatedAt(new Date());
                    return supplierRepository.save(existingSupplier);
                })
                .orElseThrow(() -> new IllegalArgumentException("Supplier not found with ID: " + id));
    }

    public void deleteSupplier(Integer id) {
        if (supplierRepository.existsById(id)) {
            supplierRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Supplier not found with ID: " + id);
        }
    }
}