package com.mtol.checker.service;


import com.mtol.checker.entity.Category;

import java.util.Optional;

public interface CategoryService {

    Category validateCategory(String name);
    Category createCategory(String name);
    Optional<Category> findCategoryByName(String name);
}
