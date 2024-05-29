package com.example.backend.dto;

import com.example.backend.dao.Price;
import com.example.backend.dao.Product;
import lombok.Data;

import java.util.List;

@Data
public class ProductInfo {
    private Product product;
    private List<Price> prices;
}
