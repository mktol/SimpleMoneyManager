package com.mtol.checker.controller;

import com.mtol.checker.entity.UserCreateForm;
import com.mtol.checker.service.SecurityService;
import com.mtol.checker.service.UserService;
import com.mtol.checker.service.validator.UserCreateFormValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.NoSuchElementException;

@Controller
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;
    private final UserCreateFormValidator userCreateFormValidator;
    @Autowired
    private SecurityService securityService;

    @Autowired
    public UserController(UserService userService, UserCreateFormValidator userCreateFormValidator) {
        this.userCreateFormValidator = userCreateFormValidator;
        this.userService = userService;
    }


    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userCreateFormValidator);
    }

    @RequestMapping("/user/{id}")
    public ModelAndView getUserPage(@PathVariable Long id) {
        return new ModelAndView("user", "form", userService.getUserById(id).orElseThrow(() -> new NoSuchElementException("User " + id + " not found")));
    }

    @RequestMapping(value = "/registration/user/create", method = RequestMethod.GET)
    public ModelAndView getUserCreatePage() {

        return new ModelAndView("create_user", "form", new UserCreateForm());
    }

    @RequestMapping(value = "/registration/user/create", method = RequestMethod.POST)
    public String handleCreateForm(@Valid @ModelAttribute("form") UserCreateForm form, BindingResult bindingResult, WebRequest request, Errors errors) {

        if (bindingResult.hasErrors()) {
            return "create_user";
        }
        try {
            userService.create(form);
            securityService.autologin(form.getEmail(), form.getPassword());
        } catch (DataIntegrityViolationException e) {
            return  "create_user";
        }
        return "redirect:/personal/expense";
    }

    @RequestMapping("/users")
    public ModelAndView getUserPage() {
        return new ModelAndView("users", "users", userService.getAllUsers());
    }
}
