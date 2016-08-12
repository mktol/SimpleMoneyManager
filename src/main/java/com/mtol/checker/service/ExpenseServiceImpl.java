package com.mtol.checker.service;

import com.mtol.checker.entity.Category;
import com.mtol.checker.entity.Expense;
import com.mtol.checker.entity.User;
import com.mtol.checker.entity.dto.ExpenseDTO;
import com.mtol.checker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    @Autowired
    private UserService userService;
    private ExpenseRepository expenseRepository;
    private CategoryService categoryService;

    @Autowired
    public ExpenseServiceImpl(ExpenseRepository expenseRepository, CategoryService categoryService) {
        this.expenseRepository = expenseRepository;
        this.categoryService = categoryService;
    }

    @Override
    public Expense saveExpense(ExpenseDTO expenseDto) {

        User user = userService.getCurrentUser();
        Expense expense = convertDtoToExpense(expenseDto);
        expense= expenseRepository.save(expense);
        expense.setUser(user);
        return expense;
    }

    @Override
    public Expense deleteExpense(Expense expense) {
        return null;
    }

    @Override
    public Long updateExpense(Expense expense) {
        return null;
    }

    @Override
    public Double sumAllExpenses() {
        return null;
    }

    @Override
    public Double sumExpenseByParam(Category category) {
//        List<Expense> expenses = expenseRepository.findByCategory(category);
//        Double res = expenses.stream().mapToDouble(c->c.getCost()).sum();
        return null;
    }


    private Expense convertDtoToExpense(ExpenseDTO dto){
        Expense expense = new Expense();
        expense.setCost(dto.getCost());
        expense.setDescription(dto.getDescription());
        Category category = categoryService.validateCategory(dto.getCategory());
        expense.addCategory(category);
        expense.setCreationTime(new Date());
        return expense;

    }


}
