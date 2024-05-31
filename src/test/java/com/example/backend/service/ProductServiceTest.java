package com.example.backend.service;

import com.example.backend.dto.ProductCalculationRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    public void test() {
        ProductCalculationRequest productCalculationRequest = new ProductCalculationRequest(1L, 1L, null);
        assertEquals(70, productService.calculatePrice(productCalculationRequest).getBody().getTotalPrice());
    }

    @Test
    public void test2() {
        ProductCalculationRequest productCalculationRequest = new ProductCalculationRequest(7L, 2L, 2L);
        assertEquals(105, productService.calculatePrice(productCalculationRequest).getBody().getTotalPrice());
    }

    @Test
    public void test3() {
        ProductCalculationRequest productCalculationRequest = new ProductCalculationRequest(4L, 7L, 7L);
        assertEquals(136, productService.calculatePrice(productCalculationRequest).getBody().getTotalPrice());
    }

    @Test
    public void getProducts(){
        assertEquals(8, productService.getProducts().size());
    }

    @Test
    public void getProductInfo(){
        assertEquals(3, productService.getProductPrices(1L).getPrices().size());
        assertEquals(30f, productService.getProductPrices(1L).getPrices().get(1).getValue());
    }
}
