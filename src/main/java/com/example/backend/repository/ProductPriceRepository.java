package com.example.backend.repository;

import com.example.backend.dao.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductPriceRepository extends JpaRepository<ProductPrice, String> {
    List<ProductPrice> findByProductId(double id);
}
