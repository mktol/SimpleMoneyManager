package com.mtol.checker.repository;

import com.mtol.checker.entity.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by mtol on 22.07.2016.
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
