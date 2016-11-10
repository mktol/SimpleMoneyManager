package com.mtol.checker.service;

import com.mtol.checker.entity.Category;
import com.mtol.checker.entity.Expense;

import com.mtol.checker.entity.User;
import com.mtol.checker.entity.dto.ExpenseDTO;

import java.util.List;

/**
<<<<<<< HEAD
 * Expense Service interface
=======
 *
>>>>>>> 45468d1978d9425efa6c6ac6e848508ba6f27729
 */
public interface ExpenseService {
    Expense saveExpense(ExpenseDTO expense);
    Expense deleteExpense(Expense expense);
    Long updateExpense(Expense expense);

    ExpenseDTO translateExpenseToDto(Expense expense);
    Expense convertDtoToExpense(ExpenseDTO dto);
    List<Expense> getExpensesByCategory(Category category);
    List<Expense> getExpensesByCategory(String name);

    Double sumAllExpenses();
    Double sumExpenseByCategory(Category category);


}
