package com.mtol.checker.repository;

import com.mtol.checker.entity.Expense;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by mtol on 08.07.2016.
 */
public interface ExpenseRepository extends CrudRepository<Expense, Long>{
}
