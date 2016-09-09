package com.mtol.checker.service;

import com.mtol.checker.entity.Category;
import com.mtol.checker.entity.Expense;
import com.mtol.checker.entity.dto.ExpenseDTO;
import com.mtol.checker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    public Long updateExpense(Expense expense) {
        return null;
    }

    @Override
    public ExpenseDTO translateExpenseToDto(Expense expense) {
        ExpenseDTO dto = new ExpenseDTO();
        dto.setCreationDate(expense.getCreationTime().toString());
        dto.setDescription(expense.getDescription());
        dto.setCost(expense.getCost().doubleValue());
        dto.setCategory(expense.getCategories().get(0).getName()); // TODO translate categories to string
        return dto;
    }


    public Expense convertDtoToExpense(ExpenseDTO dto){
        Expense expense = new Expense();
        expense.setCost(new BigDecimal(dto.getCost()));
        expense.setDescription(dto.getDescription());
        Category category = categoryService.validateCategory(dto.getCategory());
        expense.addCategory(category);
        expense.setCreationTime(new Date());
        return expense;

    }

    @Override
    public List<Expense> getExpensesByCategory(Category category) {
        return getExpensesByCategory(category.getName());
    }

    @Override
    public List<Expense> getExpensesByCategory(String name) {
        Optional<Category> category = categoryService.findCategoryByName(name);
        if(category.isPresent()){
            Category category1 = category.get();
            return category1.getExpenses();
        }else{
            return new ArrayList<>();
        }
    }


}
