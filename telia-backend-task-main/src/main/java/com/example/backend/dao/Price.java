package com.example.backend.dao;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "price")
public class Price {
    @Id
    @Column
    private double id;

    @Column(name = "commitment_months")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long commitmentMonths;

    @Column
    private float value;

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public Long getCommitmentMonths() {
        return commitmentMonths;
    }

    public void setCommitmentMonths(Long commitmentMonths) {
        this.commitmentMonths = commitmentMonths;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}