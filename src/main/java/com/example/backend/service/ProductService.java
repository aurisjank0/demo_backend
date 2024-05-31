package com.example.backend.service;

import com.example.backend.dao.Product;
import com.example.backend.dto.ProductCalculationRequest;
import com.example.backend.dto.ProductInfo;
import com.example.backend.dto.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface ProductService {

    List<Product> getProducts();

    ProductInfo getProductPrices(long id);

    ResponseEntity<Response> calculatePrice(ProductCalculationRequest productCalculationRequest);
}
