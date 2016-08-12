package com.mtol.checker.repository;

import com.mtol.checker.entity.Category;
import com.mtol.checker.entity.Expense;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by mtol on 08.07.2016.
 */
public interface ExpenseRepository extends CrudRepository<Expense, Long>{
//    List<Expense> findByCategory(Category category);
}
