package com.mtol.checker.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private BigDecimal cost;
    private String description;
    private Date creatinTime;
    @ManyToOne
    private User user;

    @ManyToMany
    @JoinTable(
            name = "EXP_CAT",
            joinColumns = @JoinColumn(name = "EXP_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "CAT_ID", referencedColumnName = "CAT_ID" )
    )
    private List<Category> categories;

    public Expense() {
        categories = new ArrayList<>();
    }

    public Expense(BigDecimal cost, String description, User user) {
        this.cost = cost;
        this.description = description;
        this.user = user;
    }

    public void addCategory(Category category){
        if(!categories.contains(category)){
            categories.add(category);
        }
        if(category.getExpenses().contains(this)){
            category.getExpenses().add(this);
        }
    }
    // Getters and setters
    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatinTime() {
        return creatinTime;
    }

    public void setCreatinTime(Date creatinTime) {
        this.creatinTime = creatinTime;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", cost=" + cost +
                ", description='" + description + '\'' +
                '}';
    }
}
