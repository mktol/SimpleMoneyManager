package com.mtol.checker.service;

import com.mtol.checker.entity.Category;
import com.mtol.checker.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements com.mtol.checker.service.CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
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
            Category cat = new Category(name);
            return categoryRepository.save(cat);
        }
    }

    @Override
    public Category createCategory(String name) {
        return null;
    }
}
