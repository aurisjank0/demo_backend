package com.example.backend.controller;


import com.example.backend.dto.ProductCalculationRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@WebMvcTest(controllers = ProductController.class,
        useDefaultFilters = false,
        includeFilters = {@ComponentScan.Filter(
                type = FilterType.ASSIGNABLE_TYPE,
                value = ProductController.class
        )
        })
public class ProductControllerTest {

    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext wContext;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProductController productController;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wContext)
                .alwaysDo(MockMvcResultHandlers.print())
                .build();
    }

    @Test
    public void calculateWillSucceed() throws Exception {
        ProductCalculationRequest request = new ProductCalculationRequest(2L, 3L, 2L);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
                        .characterEncoding("UTF-8"))
                .andExpect(status().isOk());

    }

    @Test
    public void getProductsWillSucceed() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/products")
                        .characterEncoding("UTF-8"))
                .andExpect(status().isOk());

    }

    @Test
    public void getProductByIdWillSucceed() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1//product/1")
                        .characterEncoding("UTF-8"))
                .andExpect(status().isOk());

    }


}