package com.mtol.checker.service.validator;

import com.mtol.checker.entity.ExpenseDTO;
import com.mtol.checker.service.CategoryService;
import com.mtol.checker.service.ExpenseService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ExpenseDtoValidator /*implements Validator*/ {

    private ExpenseService expenseService;
    private CategoryService categoryService;


    public boolean supports(Class<?> clazz) {
        return clazz.equals(ExpenseDTO.class);
    }


    public void validate(Object target, Errors errors) {
        ExpenseDTO expenseDTO = (ExpenseDTO)target;
        validateCost(expenseDTO, errors);

    }
    private void validateCost(ExpenseDTO expenseDTO, Errors errors){
        if(expenseDTO.getCost()<=0){
            errors.reject("cost", "cost must be bigger than 0");
        }
        if(expenseDTO.getDescription().length()<=2){
            errors.reject("descr", "description can't be less than 2 character ");
        }
    }
}
