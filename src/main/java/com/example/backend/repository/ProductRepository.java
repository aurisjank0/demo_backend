package com.example.backend.repository;

import com.example.backend.dao.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
    Product findById(double id);
}
