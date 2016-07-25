package com.mtol.checker.controller;

import com.mtol.checker.entity.Expense;
import com.mtol.checker.entity.ExpenseDTO;
import com.mtol.checker.service.validator.ExpenseDtoValidator;
import com.mtol.checker.service.ExpenseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller()
@RequestMapping(value = "/personal")
public class ExpenseController {
    private static final Logger log = LoggerFactory.getLogger(ExpenseController.class);

    private ExpenseService expenseService;
//    private ExpenseDtoValidator expenseDtoValidator;

    @Autowired
    public ExpenseController(ExpenseService expenseService, ExpenseDtoValidator expenseDtoValidator) {
        this.expenseService = expenseService;
//        this.expenseDtoValidator = expenseDtoValidator;
    }



    @RequestMapping(value = "/expense", method = RequestMethod.GET)
    public ModelAndView handleExpense(){
        ModelAndView modelAndView = new ModelAndView("expense_state");

        return modelAndView;
    }

    @RequestMapping(value = "/expense", method = RequestMethod.POST , consumes = "application/json")
    @ResponseBody
    public Expense handleExpense(@RequestBody ExpenseDTO expense) {
        log.info("expense == "+expense.toString());

        Expense resExpense = expenseService.saveExpense(expense);

        return resExpense;

    }

}
