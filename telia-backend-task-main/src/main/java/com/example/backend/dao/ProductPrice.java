package com.example.backend.dao;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product_price")
public class ProductPrice {
    @Id
    @Column
    private double id;

    @ManyToOne
    @JoinColumn(name ="product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name ="price_id")
    private Price price;

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}