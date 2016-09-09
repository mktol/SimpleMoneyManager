package com.mtol.checker.controller;

import com.mtol.checker.entity.Expense;
import com.mtol.checker.entity.dto.ExpenseDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class
 */
@RestController
public class SimpleTestContoller {

    @RequestMapping(value = "/getMeExpense", method = RequestMethod.GET)
    public ExpenseDTO getExpense(){
        ExpenseDTO expenseDTO = new ExpenseDTO();
        expenseDTO.setCategory("Food");
        expenseDTO.setCost(23.8);
        expenseDTO.setCreationDate("Monday");
        expenseDTO.setDescription("Test expense dto");
        return expenseDTO;
    }
}
