package com.anberjam.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import org.springframework.data.annotation.Id;

@Entity
@Table(name="payments")
public class Payment{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;





}