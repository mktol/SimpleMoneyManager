package com.mtol.checker.repository;

import com.mtol.checker.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByEmail(String email);

    Optional<User> findOneByEmail(String email);
    Optional<User> findOneByEmailAndPassword(String email, String password);

    Collection<User> findAll(Sort email);
}
