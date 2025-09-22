package com.anberjam.backend.service;

import com.anberjam.backend.model.Invoice;
import com.anberjam.backend.model.User;
import com.anberjam.backend.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public Invoice createInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public Optional<Invoice> getInvoiceById(Long id) {
        return invoiceRepository.findById(id);
    }

    public List<Invoice> getInvoicesByUser(User user) {
        return invoiceRepository.findByUser(user);
    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }

    public Invoice updateInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }
}
