package com.example.backend.dao;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "price")
public class Price {
    @Id
    @Column
    private double id;

    @Column(name = "commitment_months")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long commitmentMonths;

    @Column(name = "price_value")
    private float value;

}