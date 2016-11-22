package com.mtol.checker.controller;

import com.mtol.checker.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * This class
 */
@Service
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(value = "/categories/autocomplete", method = RequestMethod.GET)
    @ResponseBody()
    public Set<String> autocomplete(@RequestParam String catName){
        Set<String> names = categoryRepository.findByNameLike(catName).stream().map(category -> category.getName()).collect(Collectors.toSet());
        return  names;
    }
}
