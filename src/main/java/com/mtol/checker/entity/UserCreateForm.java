package com.mtol.checker.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * DTO object
 */
public class UserCreateForm {

    @NotEmpty
    private String name = "";

    @NotEmpty
    private String email = "";

    @NotEmpty
//    @Size(min =3, max= 15, message = "Your password  must between 3 and 15 ")
    private String password = "";


    @NotNull
    private UserRole role = UserRole.USER;

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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}