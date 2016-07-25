package com.mtol.checker.service;


import com.mtol.checker.entity.Category;

public interface CategoryService {

    Category validateCategory(String name);
    Category createCategory(String name);
}
