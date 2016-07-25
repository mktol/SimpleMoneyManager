package com.mtol.checker.service;

import com.mtol.checker.entity.Category;
import com.mtol.checker.entity.Expense;
import com.mtol.checker.entity.ExpenseDTO;
import com.mtol.checker.repository.CategoryRepository;
import com.mtol.checker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    private ExpenseRepository expenseRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public ExpenseServiceImpl(ExpenseRepository expenseRepository, CategoryRepository categoryRepository) {
        this.expenseRepository = expenseRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Long saveExpense(ExpenseDTO expense) {

        return null;
    }

    @Override
    public Expense deleteExpense(Expense expense) {
        return null;
    }

    @Override
    public Long updateExpemse(Expense expense) {
        return null;
    }


}
