package com.mtol.checker.service;

import com.mtol.checker.entity.User;
import com.mtol.checker.entity.UserCreateForm;
import com.mtol.checker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

/**
 * Service implementation
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getUserById(long id) {
        return Optional.ofNullable(userRepository.findOne(id));
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

    @Override
    public Collection<User> getAllUsers() {
        return userRepository.findAll(new Sort("email"));
    }

    @Override
    public Optional<User> getUserByEmailAndPassword(String email, String password) {
        return userRepository.findOneByEmailAndPassword(email, password);
    }

    @Override
    public User create(UserCreateForm form) {
        System.out.println();
        User user = new User();

        user.setEmail(form.getEmail());
        user.setName(form.getName());
//        user.setPassword( new BCryptPasswordEncoder().encode("1111"));
        user.setPassword( new BCryptPasswordEncoder().encode(form.getPassword()));
        user.setRole(form.getRole());
        return userRepository.save(user);
    }
}
