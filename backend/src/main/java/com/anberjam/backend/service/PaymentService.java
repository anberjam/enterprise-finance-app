package com.anberjam.backend.service;

import com.anberjam.backend.model.Invoice;
import com.anberjam.backend.model.Payment;
import com.anberjam.backend.model.User;
import com.anberjam.backend.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    // Create a new payment
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    // Retrieve a payment by its ID
    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    // Get all payments made by a specific user
    public List<Payment> getPaymentsByUser(User user) {
        return paymentRepository.findByUser(user);
    }

    // Get all payments for a specific invoice
    public List<Payment> getPaymentsByInvoice(Invoice invoice) {
        return paymentRepository.findByInvoice(invoice);
    }

    // Get all payments in the system
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    // Delete a payment by its ID
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }

    // Update an existing payment
    public Payment updatePayment(Payment payment) {
        return paymentRepository.save(payment);
    }
}
