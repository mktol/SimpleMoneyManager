package com.mtol.checker.controller;

import com.mtol.checker.entity.UserCreateForm;
import com.mtol.checker.service.UserCreateFormValidator;
import com.mtol.checker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.annotation.AccessType;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.NoSuchElementException;

@Controller
public class UserController {

    private final UserService userService;
    private final UserCreateFormValidator userCreateFormValidator;

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

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public String handleCreateForm(@Valid @ModelAttribute("form") UserCreateForm form, BindingResult bindingResult, HttpRequest request) {

        if (bindingResult.hasErrors()) {
            return "create_user";
        }
        try {
            userService.create(form);
        } catch (DataIntegrityViolationException e) {

            return  "create_user";
        }

        return "redirect:/users";
    }

    public ModelAndView getUserPage() {
        return new ModelAndView("users", "users", userService.getAllUsers());
    }
}
