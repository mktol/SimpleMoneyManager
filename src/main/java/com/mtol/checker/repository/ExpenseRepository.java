package com.mtol.checker.repository;

import com.mtol.checker.entity.Category;
import com.mtol.checker.entity.Expense;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long>{

    @Query("select sum(e.cost) from Expense e ")
    Double sumAll();


//    List<Expense> getExpensesByU
//    List<Expense> findByCategory(Category category);
}
