package com.mtol.checker.service;

import com.mtol.checker.entity.Category;
import com.mtol.checker.entity.Expense;
import com.mtol.checker.entity.dto.ExpenseDTO;

import java.util.List;

/**
 * Expense Service interface
 */
public interface ExpenseService {
    Expense saveExpense(ExpenseDTO expense);
    Expense deleteExpense(Expense expense);
    Long updateExpense(Expense expense);

    ExpenseDTO translateExpenseToDto(Expense expense);
    Expense convertDtoToExpense(ExpenseDTO dto);
    List<Expense> getExpensesByCategory(Category category);
    List<Expense> getExpensesByCategory(String name);
    List<Expense> getExpensesForCurrentUser();
    List<ExpenseDTO> translateExpenseToDto(List<Expense> expenses);
    List<Expense> translateExpenseDtoToExpense(List<ExpenseDTO> expenses);

    Double sumAllExpenses();
    Double sumAllExpensesForCurrentUser();
    Double sumExpenseByCategory(Category category);


}
