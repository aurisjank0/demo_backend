package com.example.backend.controller;

import com.example.backend.dao.Product;
import com.example.backend.dto.ProductInfo;
import com.example.backend.dto.Request;
import com.example.backend.dto.Response;
import com.example.backend.service.ProductService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@SecurityRequirement(name = "basic")
@RequestMapping("/api/v1")
public class Controller {

    @Autowired
    ProductService productService;


//    @PreAuthorize("hasAuthority('USER')")
    @GetMapping(value = "/products")
    @ResponseBody
    public List<Product> getProducts() {
        return productService.getProducts();
    }

//    @PreAuthorize("hasAuthority('USER')")
    @GetMapping(value = "/product/{id}")
    @ResponseBody
    public ProductInfo getProductPrice(@PathVariable double id) {
        return productService.getProductPrices(id);
    }

//    @PreAuthorize("hasAuthority('USER')")
    @PostMapping(value = "/calculate")
    @ResponseBody
    public ResponseEntity<Response> calculatePrice(@RequestParam double productId,
                                                   @RequestParam Long commitment,
                                                   @RequestParam(required = false) Optional<String> returnMonths) {
        Request request;
        if (returnMonths.isPresent() && returnMonths.get().equals("null")) {
            request = new Request(productId, commitment, null);
        } else {
            request = new Request(productId, commitment, returnMonths.get());
        }
        return productService.calculatePrice(request);
    }

}
