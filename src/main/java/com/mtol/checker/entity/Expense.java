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
    private Double cost;
    private String description;
    private Date creationTime;
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

    public Expense(Double cost, String description, User user) {
        this.cost = cost;
        this.description = description;
        this.user = user;
        categories = new ArrayList<>();
    }

    public void addCategory(Category category){
        if(!categories.contains(category)){
            categories.add(category);
        }
        if(!category.getExpenses().contains(this)){
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

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", cost=" + cost +
                ", description='" + description + '\'' +
                ", creationTime=" + creationTime +
                ", user=" + user +
                ", categories=" + categories +
                '}';
    }
}
