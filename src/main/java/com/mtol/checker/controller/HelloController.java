package com.mtol.checker.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import java.util.Date;
import java.util.Map;

@RestController
public class HelloController {

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("hello");
    }


    @Value("${application.message:Hello World}")
    private String message = "Hello World";

    @RequestMapping("/hello")
    public ModelAndView welcome(Map<String, Object> model) {
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("time", new Date());
        modelAndView.addObject("message", this.message);
        return modelAndView;
    }

    @RequestMapping("/foo")
    public String foo(Map<String, Object> model) {
        throw new RuntimeException("Foo");
    }



}