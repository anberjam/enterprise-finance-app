package com.anberjam.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name="vendors")
public class Vender {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    private String address;
    private String emailAddress;
    private String phoneNumber;

    public Vender() {}

    public Vender(String name, String emailAddress, String phoneNumber){
        this.name = name;
        this.address = address;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;


    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



}