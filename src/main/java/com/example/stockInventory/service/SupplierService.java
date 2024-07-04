package com.example.stockInventory.service;

import com.example.stockInventory.entity.Supplier;
import com.example.stockInventory.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public Supplier addSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Supplier updateSupplier(Long id, Supplier updatedSupplier) {
        Optional<Supplier> existingSupplier = supplierRepository.findById(id);
        if (existingSupplier.isPresent()) {
            Supplier supplier = existingSupplier.get();
            supplier.setName(updatedSupplier.getName());
            supplier.setContactInfo(updatedSupplier.getContactInfo());
            return supplierRepository.save(supplier);
        }
        return null;
    }

    public void removeSupplier(Long id) {
        supplierRepository.deleteById(id);
    }

    public Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id).orElse(null);
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }
}
