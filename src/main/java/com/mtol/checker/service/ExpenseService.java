package com.mtol.checker.service;

import com.mtol.checker.entity.Category;
import com.mtol.checker.entity.Expense;

import com.mtol.checker.entity.User;
import com.mtol.checker.entity.dto.ExpenseDTO;

/**
 *
 */
public interface ExpenseService {
    Expense saveExpense(ExpenseDTO expense);
    Expense deleteExpense(Expense expense);
    Long updateExpense(Expense expense);
    Double sumAllExpenses();
    Double sumExpenseByParam(Category category);

}
