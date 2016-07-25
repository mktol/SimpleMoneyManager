package com.mtol.checker.entity;

import org.hibernate.validator.constraints.NotEmpty;

import java.math.BigDecimal;

/**
 * Created by mtol on 22.07.2016.
 */
public class ExpenseDTO {
    @NotEmpty
    private Double cost;
    private String description;
    private String category;

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ExpenseDTO{" +
                "cost=" + cost +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
