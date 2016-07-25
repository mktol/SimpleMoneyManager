package com.mtol.checker.repository;

import com.mtol.checker.entity.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findOneByName(String name);
}
