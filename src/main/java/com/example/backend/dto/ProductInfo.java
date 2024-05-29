package com.example.backend.dto;

import com.example.backend.dao.Price;
import com.example.backend.dao.Product;

import java.util.List;


public class ProductInfo {
    private Product product;
    private List<Price> prices;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }
}
