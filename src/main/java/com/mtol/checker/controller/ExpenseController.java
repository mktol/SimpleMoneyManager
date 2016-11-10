package com.mtol.checker.controller;

import com.mtol.checker.entity.Expense;
import com.mtol.checker.entity.dto.ExpenseDTO;
import com.mtol.checker.service.validator.ExpenseDtoValidator;
import com.mtol.checker.service.ExpenseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    public ModelAndView handleExpense() {
        log.info("sum all expenses. sum = "+expenseService.sumAllExpenses().toString());
        ModelAndView modelAndView = new ModelAndView("expense_state");
        return modelAndView;
    }

    @RequestMapping(value = "/expense", method = RequestMethod.POST)
    @ResponseBody
    public ExpenseDTO handleExpense(@RequestBody ExpenseDTO expense) {
        log.info("expense == " + expense.toString());
        Expense resExpense = expenseService.saveExpense(expense);
        expense.setCreationDate(resExpense.getCreationTime().toString());

        return expense;
    }

    @RequestMapping(value = "/expenses", method = RequestMethod.POST)
    @ResponseBody()
    public ExpenseDTO[] getExpenses() {
        ExpenseDTO[] expenseDTOs = new ExpenseDTO[5];
        for (int i = 0; i < expenseDTOs.length; i++) {
            ExpenseDTO expense = new ExpenseDTO();
            expense.setCategory("food");
            expense.setCost(33.0 + ((double) i));
            expense.setCreationDate(new Date().toString());
            expense.setDescription("Description = " + i);
            expenseDTOs[i] = expense;
        }
        return expenseDTOs;
    }

    // TODO CHECK IT
    @RequestMapping(value = "/expenses/{categoy}", method = RequestMethod.GET)// TODO only for test. Change it to /epenses and work with request parameters, not url path.
    @ResponseBody()
    public List<ExpenseDTO> getExpensesByCategoryName(@PathVariable("categoy") String category){
        List<Expense> expenses = expenseService.getExpensesByCategory(category);
        List<ExpenseDTO> expenseDTOs = expenses.stream().map((Expense inp)->{ //TODO move this code to service method
            return expenseService.translateExpenseToDto(inp);
        } ).collect(Collectors.toList());

        return expenseDTOs;
    }

}
