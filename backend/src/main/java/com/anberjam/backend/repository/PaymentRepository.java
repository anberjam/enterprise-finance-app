package com.anberjam.backend.repository;

import com.anberjam.backend.model.Invoice;
import com.anberjam.backend.model.Payment;
import com.anberjam.backend.model.PaymentStatus;
import com.anberjam.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    // Find all payments by payer
    List<Payment> findByPayer(String payer);

    // Find all payments by status
    List<Payment> findByStatus(PaymentStatus status);

    // Find all payments by payee
    List<Payment> findByPayee(String payee);

    List<Payment> findByUser(User user);

    List<Payment> findByInvoice(Invoice invoice);
}
