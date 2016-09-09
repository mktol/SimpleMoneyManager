package com.mtol.checker.service;

import com.mtol.checker.entity.Category;
import com.mtol.checker.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServeiceImpl implements com.mtol.checker.service.CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
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
            Category category1 = new Category(name);
            Category resultCategory = categoryRepository.save(category1);
            return resultCategory;
        }
    }

    @Override
    public Category createCategory(String name) {
        Category category = new Category(name);
        Category savedCategory = categoryRepository.save(category);
        return savedCategory;
    }

    @Override
    public Optional<Category> findCategoryByName(String name) {
        Optional<Category> category = categoryRepository.findOneByName(name);
        return category;
    }
}
