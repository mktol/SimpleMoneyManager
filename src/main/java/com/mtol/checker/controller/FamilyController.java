package com.mtol.checker.controller;

import com.mtol.checker.entity.Family;
import com.mtol.checker.entity.User;
import com.mtol.checker.service.FamilyService;
import com.mtol.checker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for family entity
 */
@Controller
public class FamilyController {

    @Autowired
    private UserService userService;

    private FamilyService familyService;

    @RequestMapping("/family")
    public ModelAndView getFamilyPage(){
        User user = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView("family_page");
        Family family = user.getFamily();
        if(family==null) {
            modelAndView.addObject("family", "you are alone");
            modelAndView.addObject("familySize", "0");

        }else {
            modelAndView.addObject("family", family.getName());
            modelAndView.addObject("familySize", "1");
        }
        return modelAndView;
    }

/*    @RequestMapping("/family/create")
    public ModelAndView createFamily(@RequestParam("familyName") String familyName){


    }*/
}
