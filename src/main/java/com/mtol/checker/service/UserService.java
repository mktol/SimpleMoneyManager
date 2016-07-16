package com.mtol.checker.service;


import com.mtol.checker.entity.User;
import com.mtol.checker.entity.UserCreateForm;

import java.util.Collection;
import java.util.Optional;

public interface UserService {
    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

    Optional<User> getUserByEmailAndPassword(String email, String password);

    User create(UserCreateForm form);
}
