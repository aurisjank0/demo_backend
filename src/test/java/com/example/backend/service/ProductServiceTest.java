package com.example.backend.service;

import com.example.backend.dto.Request;
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
        Request request = new Request(1L, 1L, null);
        assertEquals(productService.calculatePrice(request).getBody().getTotalPrice(), 70);
    }

    @Test
    public void test2() {
        Request request = new Request(7L, 2L, "2");
        assertEquals(productService.calculatePrice(request).getBody().getTotalPrice(), 105);
    }

    @Test
    public void test3() {
        Request request = new Request(4L, 7L, "7");
        assertEquals(productService.calculatePrice(request).getBody().getTotalPrice(), 136);
    }

    @Test
    public void getProducts(){
        assertEquals(productService.getProducts().size(), 8);
    }

    @Test
    public void getProductInfo(){
        assertEquals(productService.getProductPrices(1L).getPrices().size(), 3);
        assertEquals(productService.getProductPrices(1L).getPrices().get(1).getValue(), 30f);
    }
}
