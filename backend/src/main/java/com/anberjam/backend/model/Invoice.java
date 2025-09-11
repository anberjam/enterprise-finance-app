package com.anberjam.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name="invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="vender_id", nullable=false)
    private Vender vender;

    @Column(nullable=false)
    private BigDecimal totalPrice;

    @Column(nullable=false;)
    private LocalDate dueDate;

    private Boolean paid;

    public Invoice() {}

    public Invoice(Vender vender, BigDecimal totalPrice, LocalDate dueDate, Boolean paid) {
        this.vender = vender;
        this.totalPrice = totalPrice;
        this.dueDate = dueDate;
        this.paid = paid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vender getVender() {
        return vender;
    }

    public void setVender(Vender vender) {
        this.vender = vender;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }
}