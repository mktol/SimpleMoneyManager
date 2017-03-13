package com.mtol.checker.controller;

import com.mtol.checker.entity.Category;
import com.mtol.checker.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Category autocomplete controller
 */
@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(value = "/categories/autocomplete/{categ}", method = RequestMethod.GET)
    @ResponseBody()
    public Set<String> autocomplete(@PathVariable String categ){
        Set<Category> names = categoryRepository.findByNameStartingWith(categ);
        return  names.stream().map(Category::getName).collect(Collectors.toSet());
    }
}
