package com.example.backend.dto;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;
    private String email;
    private long expiresIn;
}