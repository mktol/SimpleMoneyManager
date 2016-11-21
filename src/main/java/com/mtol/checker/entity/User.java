package com.mtol.checker.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Expense> expenses = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<ExpectedSpending> spendings = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private UserRole role;
    @ManyToOne
    private Family family;

    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Family addFamily(Family family){
        if(family == null){
            this.family = family;
        }
        if(family !=null && !family.getUsers().contains(this)){
            family.addUser(this);
        }
        return family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public List<ExpectedSpending> getSpendings() {
        return spendings;
    }

    public void setSpendings(List<ExpectedSpending> spendings) {
        this.spendings = spendings;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
