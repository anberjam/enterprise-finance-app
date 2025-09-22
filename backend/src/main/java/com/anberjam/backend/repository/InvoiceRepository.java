package com.anberjam.backend.repository;

import com.anberjam.backend.model.Invoice;
import com.anberjam.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    List<Invoice> findByUser(User user);
}
