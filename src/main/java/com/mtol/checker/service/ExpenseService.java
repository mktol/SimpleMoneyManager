package com.mtol.checker.service;

import com.mtol.checker.entity.Category;
import com.mtol.checker.entity.Expense;
import com.mtol.checker.entity.ExpenseDTO;
import com.mtol.checker.entity.User;

/**
 * Created by mtol on 22.07.2016.
 */
public interface ExpenseService {
    Expense saveExpense(ExpenseDTO expense);
    Expense deleteExpense(Expense expense);
    Long updateExpemse(Expense expense);
    Double sumAllExpenses();
    Double sumExpenseByParam(Category category);

}
