package com.example.backend.dto;

import lombok.Data;

@Data
public class Response {
    private Long months;
    private float totalPrice;
    private String message;
}
