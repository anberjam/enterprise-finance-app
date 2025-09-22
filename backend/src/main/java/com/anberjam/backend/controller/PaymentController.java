package com.anberjam.backend.controller;

import com.anberjam.backend.model.Invoice;
import com.anberjam.backend.model.Payment;
import com.anberjam.backend.model.User;
import com.anberjam.backend.service.InvoiceService;
import com.anberjam.backend.service.PaymentService;
import com.anberjam.backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;
    private final UserService userService;
    private final InvoiceService invoiceService;

    public PaymentController(PaymentService paymentService, UserService userService, InvoiceService invoiceService) {
        this.paymentService = paymentService;
        this.userService = userService;
        this.invoiceService = invoiceService;
    }

    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        return ResponseEntity.ok(paymentService.createPayment(payment));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long id) {
        return paymentService.getPaymentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Payment>> getPaymentsByUser(@PathVariable Long userId) {
        return userService.getUserById(userId)
                .map(user -> ResponseEntity.ok(paymentService.getPaymentsByUser(user)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/invoice/{invoiceId}")
    public ResponseEntity<List<Payment>> getPaymentsByInvoice(@PathVariable Long invoiceId) {
        return invoiceService.getInvoiceById(invoiceId)
                .map(invoice -> ResponseEntity.ok(paymentService.getPaymentsByInvoice(invoice)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment payment) {
        payment.setId(id);
        return ResponseEntity.ok(paymentService.updatePayment(payment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return ResponseEntity.noContent().build();
    }
}
