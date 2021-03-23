package com.example.backend.dto;

import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

public class Request {
    private double productId;
    private Long commitment;
    private String returnMonths;

    public Request(double productId, Long commitment, String returnMonths) {
        this.productId = productId;
        this.commitment = commitment;
        this.returnMonths = returnMonths;
    }

    public double getProductId() {
        return productId;
    }

    public void setProductId(double productId) {
        this.productId = productId;
    }

    public Long getCommitment() {
        return commitment;
    }

    public void setCommitment(Long commitment) {
        this.commitment = commitment;
    }

    public String getReturnMonths() {
        return returnMonths;
    }

    public void setReturnMonths(String returnMonths) {
        this.returnMonths = returnMonths;
    }
}
