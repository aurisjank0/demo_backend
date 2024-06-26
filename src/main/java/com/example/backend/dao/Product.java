package com.example.backend.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "product", schema = "DEV_DB")
public class Product {
    @Id
    @Column
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "rentable")
    private boolean rentable;
}