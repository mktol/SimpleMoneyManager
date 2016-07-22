package com.mtol.checker.controller;

import com.mtol.checker.entity.Expense;
import com.mtol.checker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@Controller()
@RequestMapping(value = "/personal")
public class ExpenseController {

    private ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @RequestMapping(value = "/expense", method = RequestMethod.GET)
    public ModelAndView handleExpense(){
        ModelAndView modelAndView = new ModelAndView("expense_state");

        return modelAndView;
    }

    @RequestMapping(value = "/expense", method = RequestMethod.POST)
    public ModelAndView handleExpense(@RequestParam Expense expense) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("expense_state");
        Long id = expenseService.saveExpense(expense);
        modelAndView.addObject("exp_id", id);
        return modelAndView;

    }

}
