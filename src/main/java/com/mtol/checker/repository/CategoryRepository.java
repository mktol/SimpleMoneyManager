package com.mtol.checker.repository;

import com.mtol.checker.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findOneByName(String name);
    Set<Category> findByNameLike(String name);
}
