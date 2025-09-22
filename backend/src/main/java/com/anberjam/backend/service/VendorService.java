package com.anberjam.backend.service;

import com.anberjam.backend.model.Vendor;
import com.anberjam.backend.repository.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendorService {

    private final VendorRepository vendorRepository;

    public VendorService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    // Create a new vendor
    public Vendor createVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    // Get vendor by ID
    public Optional<Vendor> getVendorById(Long id) {
        return vendorRepository.findById(id);
    }

    // Get all vendors
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    // Update a vendor
    public Vendor updateVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    // Delete a vendor by ID
    public void deleteVendor(Long id) {
        vendorRepository.deleteById(id);
    }
}
