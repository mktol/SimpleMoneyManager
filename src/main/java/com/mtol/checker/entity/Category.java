package com.mtol.checker.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "CAT_ID")
    Long id;
    private String name;
    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    private List<Expense> expenses;

    public Category() {
        expenses = new ArrayList<>();
    }

    public Category(String name){
        this.name = name;
        expenses = new ArrayList<>();
    }

    public void addExpnse(Expense expense){
        if(!expenses.contains(expense)){
            expenses.add(expense);
        }
        if(!expense.getCategories().contains(this)){
            expense.getCategories().add(this);
        }
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
