package com.example.backend.service;

import com.example.backend.dao.Product;
import com.example.backend.dto.ProductInfo;
import com.example.backend.dto.Request;
import com.example.backend.dto.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface ProductService {

    List<Product> getProducts();

    ProductInfo getProductPrices(double id);

    ResponseEntity<Response> calculatePrice(Request request);
}
