package com.example.backend.controller;

import com.example.backend.dao.Product;
import com.example.backend.dto.ProductCalculationRequest;
import com.example.backend.dto.ProductInfo;
import com.example.backend.dto.Response;
import com.example.backend.service.ProductService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SecurityRequirement(name = "jwt")
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    ProductService productService;


    @GetMapping(value = "/products")
    @ResponseBody
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping(value = "/product/{id}")
    @ResponseBody
    public ProductInfo getProductPrice(@PathVariable long id) {
        return productService.getProductPrices(id);
    }

    @PostMapping(value = "/calculate")
    @ResponseBody
    public ResponseEntity<Response> calculatePrice(@RequestBody ProductCalculationRequest productCalculationRequest) {
        if (productCalculationRequest.getProductId() == null || productCalculationRequest.getCommitment() == null) {
            return ResponseEntity.badRequest().build();
        }
        return productService.calculatePrice(productCalculationRequest);
    }

}
