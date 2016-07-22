package com.mtol.checker.service;

import com.mtol.checker.entity.Expense;

/**
 * Created by mtol on 22.07.2016.
 */
public interface ExpenseService {
    Long saveExpense(Expense expense);
    Expense deleteExpense(Expense expense);
    Long updateExpemse(Expense expense);

}
