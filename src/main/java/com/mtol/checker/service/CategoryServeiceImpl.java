package com.mtol.checker.service;

import com.mtol.checker.entity.Category;
import com.mtol.checker.repository.CategoryRepository;

import java.util.Optional;

/**
 * Created by mtol on 22.07.2016.
 */
public class CategoryServeiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServeiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * Check if exist category in db if not save it in db and return persisted category
     * @param name
     * @return
     */
    @Override
    public Category validateCategory(String name) {
        Optional<Category> category = categoryRepository.findOneByName(name);
        if(category.isPresent()){
            return category.get();
        }else {
            return categoryRepository.save(new Category(name));
        }
    }

    @Override
    public Category createCategory(String name) {
        return null;
    }
}
