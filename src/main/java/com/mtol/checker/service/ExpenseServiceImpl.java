package com.mtol.checker.service;

import com.mtol.checker.entity.Category;
import com.mtol.checker.entity.Expense;
import com.mtol.checker.entity.ExpenseDTO;
import com.mtol.checker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    private ExpenseRepository expenseRepository;
    private CategoryService categoryService;

    @Autowired
    public ExpenseServiceImpl(ExpenseRepository expenseRepository, CategoryService categoryService) {
        this.expenseRepository = expenseRepository;
        this.categoryService = categoryService;
    }

    @Override
    public Expense saveExpense(ExpenseDTO expenseDto) {

        Expense expense = convertDtoToExpense(expenseDto);
        expense= expenseRepository.save(expense);
        return expense;
    }

    @Override
    public Expense deleteExpense(Expense expense) {
        return null;
    }

    @Override
    public Long updateExpemse(Expense expense) {
        return null;
    }

    @Override
    public Double sumAllExpenses() {
        return null;
    }

    @Override
    public Double sumExpenseByParam(Category category) {
        return null;
    }


    private Expense convertDtoToExpense(ExpenseDTO dto){
        Expense expense = new Expense();
        expense.setCost(new BigDecimal(dto.getCost()));
        expense.setDescription(dto.getDescription());
        Category category = categoryService.validateCategory(dto.getCategory());
        expense.addCategory(category);
        expense.setCreatinTime(new Date());
        return expense;

    }


}
