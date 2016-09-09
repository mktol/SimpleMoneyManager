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
}