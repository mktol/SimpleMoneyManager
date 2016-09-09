package com.mtol.checker.repository;

import com.mtol.checker.entity.Category;
import com.mtol.checker.entity.Expense;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mtol on 08.07.2016.
 */
@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long>{
//    List<Expense> findByCategory(Category category);
}
