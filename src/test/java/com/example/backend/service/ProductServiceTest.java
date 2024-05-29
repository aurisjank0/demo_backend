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
        assertEquals(70, productService.calculatePrice(request).getBody().getTotalPrice());
    }

    @Test
    public void test2() {
        Request request = new Request(7L, 2L, "2");
        assertEquals(105, productService.calculatePrice(request).getBody().getTotalPrice());
    }

    @Test
    public void test3() {
        Request request = new Request(4L, 7L, "7");
        assertEquals(136, productService.calculatePrice(request).getBody().getTotalPrice());
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
