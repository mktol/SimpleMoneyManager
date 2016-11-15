package com.mtol.checker.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Describe planing expense on day
 */
@Entity
public class ExpectedSpending {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Double expectedExpense;
    private Date endDate; //TODO should it be LocalDate java 8
    private Date startDate;

    @ManyToOne
    private User user;

    public Double getExpectedExpense() {
        return expectedExpense;
    }

    public void setExpectedExpense(Double expectedExpense) {
        this.expectedExpense = expectedExpense;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
