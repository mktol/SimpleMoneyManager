package com.mtol.checker.controller;

import com.mtol.checker.entity.Expense;
import com.mtol.checker.entity.User;
import com.mtol.checker.entity.dto.ExpenseDTO;
import com.mtol.checker.entity.dto.ExpenseListWrapper;
import com.mtol.checker.service.ExpenseService;
import com.mtol.checker.service.UserService;
import com.mtol.checker.service.validator.ExpenseDtoValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller()
@RequestMapping(value = "/personal")
public class ExpenseController {
    private static final Logger log = LoggerFactory.getLogger(ExpenseController.class);

    private ExpenseService expenseService;
    @Autowired
    private UserService userService;

    @Autowired
    public ExpenseController(ExpenseService expenseService, ExpenseDtoValidator expenseDtoValidator) {
        this.expenseService = expenseService;
    }


    @RequestMapping(value = "/expense", method = RequestMethod.GET)
    public ModelAndView handleExpense() {
        Double expenseSum = expenseService.sumAllExpenses();
        log.info("sum all expenses. sum = "+expenseSum.toString());
        ModelAndView modelAndView = new ModelAndView("expense_state");
        User current = userService.getCurrentUser();
        modelAndView.addObject("user_name", current.getName());
        modelAndView.addObject("user_email", current.getEmail());
        modelAndView.addObject("expense_sum", expenseSum);
        return modelAndView;
    }

    @RequestMapping(value = "/expense", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.CREATED)
    public ExpenseDTO handleExpense(@RequestBody ExpenseDTO expense) {
        log.info("expense == " + expense.toString());
        Expense resExpense = expenseService.saveExpense(expense);
        expense.setCreationDate(resExpense.getCreationTime().toString());

        return expense;
    }

    @RequestMapping(value = "/expenses", method = RequestMethod.GET)
    @ResponseBody()
    public ExpenseListWrapper getExpenses() {
        List<ExpenseDTO> expenseDTOs = new ArrayList<>();
        for (int i = 0; i < 5; i++) { // test data
            ExpenseDTO expense = new ExpenseDTO();
            expense.setCategory("food");
            expense.setCost(33.0 + ((double) i));
            expense.setCreationDate(new Date().toString());
            expense.setDescription("Description = " + i);
            expenseDTOs.add(expense);
        }
        ExpenseListWrapper result = new ExpenseListWrapper();
        List<Expense> expenses = expenseService.getExpensesForCurrentUser();

        result.setData(expenseService.translateExpenseToDto(expenses));
        return result;
    }

    // TODO CHECK IT
    @RequestMapping(value = "/expenses/{categoy}", method = RequestMethod.GET)// TODO only for test. Change it to /expenses and work with request parameters, not url path.
    @ResponseBody()
    public List<ExpenseDTO> getExpensesByCategoryName(@PathVariable("categoy") String category){
        List<Expense> expenses = expenseService.getExpensesByCategory(category);
        List<ExpenseDTO> expenseDTOs = expenses.stream().map((Expense inp)->{ //TODO move this code to service method
            return expenseService.translateExpenseToDto(inp);
        } ).collect(Collectors.toList());

        return expenseDTOs;
    }

}
