package com.mtol.checker.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Dummy Family
 */
@Entity
public class Family {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "family")
    private Set<User> users = new HashSet<>();

    public Long getId() {
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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public User addUser(User user) {
        if(!users.contains(user)){
            users.add(user);
            user.addFamily(this);
        }
        return user;
    }
}
