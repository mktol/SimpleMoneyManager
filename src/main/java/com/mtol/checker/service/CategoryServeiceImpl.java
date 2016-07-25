package com.mtol.checker.service;

import com.mtol.checker.entity.Category;
import com.mtol.checker.repository.CategoryRepository;
import com.mtol.checker.repository.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServeiceImpl implements com.mtol.checker.service.CategoryService {

    private CategoryRepository categoryService;

    public CategoryServeiceImpl(CategoryRepository categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * Check if exist category in db if not save it in db and return persisted category
     * @param name
     * @return
     */
    @Override
    public Category validateCategory(String name) {
        Optional<Category> category = categoryService.findOneByName(name);
        if(category.isPresent()){
            return category.get();
        }else {
            return categoryService.save(new Category(name));
        }
    }

    @Override
    public Category createCategory(String name) {
        return null;
    }
}
