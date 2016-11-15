package com.mtol.checker.repository;

import com.mtol.checker.entity.Expense;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long> {

    @Query("select sum(e.cost) from Expense e ")
    Double sumAll();

    //SELECT sum(expense.cost) FROM moneychecker.expense inner join (select * from user where user.email = 'mtol@gmail.ua') as users on expense.user_id=users.id ;

    // SELECT sum(expense.cost) FROM moneychecker.expense inner join user as us on expense.user_id=us.id inner join user on user.email = 'mtol@gmail.ua'
//    @Query("select sum(e.cost) from Expense e, User us inner join us on e.user.id = 1 ")
//    Double sumAllByUserEmail();


//    List<Expense> getExpensesByU
//    List<Expense> findByCategory(Category category);
}
