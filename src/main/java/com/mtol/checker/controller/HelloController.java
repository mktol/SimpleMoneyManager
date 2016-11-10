package com.mtol.checker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloController {

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("hello");
    }
}