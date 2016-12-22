package com.mtol.checker.service;

import com.mtol.checker.entity.Category;
import com.mtol.checker.entity.Expense;
import com.mtol.checker.entity.User;
import com.mtol.checker.entity.dto.ExpenseDTO;
import com.mtol.checker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


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
        expense.setUser(user);
        expense= expenseRepository.save(expense);
        return expense;
    }

    @Override
    public Expense deleteExpense(Expense expense) {

        expenseRepository.delete(expense);
        return null;
    }

    @Override
    public Long updateExpense(Expense expense) {


        return null;
    }

    @Override
    public Double sumAllExpenses() {
        return expenseRepository.sumAll();
    }

    @Override
    public Double sumAllExpensesForCurrentUser() {
        return null;
    }

    /**
     * sum expenses by category
     * @param category global category of expense
     * @return sum expense by category
     */
    @Override
    public Double sumExpenseByCategory(Category category) {
        return category.getExpenses().stream().mapToDouble(Expense::getCost).sum();
    }

    @Override
    public ExpenseDTO translateExpenseToDto(Expense expense) {
        ExpenseDTO dto = new ExpenseDTO();
        dto.setCreationDate(expense.getCreationTime().toString());
        dto.setDescription(expense.getDescription());
        dto.setCost(expense.getCost());
        dto.setCategory(expense.getCategories().get(0).getName()); // TODO translate categories to string
        return dto;
    }

    @Override
    public Expense convertDtoToExpense(ExpenseDTO dto){ //TODO should I move it to UTIL class
        Expense expense = new Expense();
        expense.setCost(dto.getCost());
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

    @Override
    public List<Expense> getExpensesForCurrentUser() { // TODO create method that return only first numbers of expense
        User user = userService.getCurrentUser();
        return new ArrayList<>(user.getExpenses());
    }

    @Override
    public List<ExpenseDTO> translateExpenseToDto(List<Expense> expenses) {
        List<ExpenseDTO> expenseDTOs = new ArrayList<>();
        for (Expense expense : expenses) {
            expenseDTOs.add(translateExpenseToDto(expense));
        }
        return expenseDTOs;
    }

    @Override
    public List<Expense> translateExpenseDtoToExpense(List<ExpenseDTO> expenses) {
        return Collections.emptyList();
    }

}
