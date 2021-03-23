package com.example.backend.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product", schema = "DEV_DB")
public class Product {
    @Id
    @Column
    private double id;

    @Column(name = "title")
    private String title;

    @Column(name = "rentable")
    private boolean rentable;

    public double getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isRentable() {
        return rentable;
    }

    public void setId(double id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRentable(boolean rentable) {
        this.rentable = rentable;
    }
}