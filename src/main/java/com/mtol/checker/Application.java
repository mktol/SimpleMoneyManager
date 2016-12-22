package com.mtol.checker;

import com.mtol.checker.entity.*;
import com.mtol.checker.repository.CategoryRepository;
import com.mtol.checker.repository.ExpenseRepository;
import com.mtol.checker.repository.FamilyRepository;
import com.mtol.checker.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@ComponentScan
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);


    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
/*
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }*/

    }

    @Bean
    public CommandLineRunner demo(UserRepository repository, ExpenseRepository expenseRepository, CategoryRepository categoryRepository, FamilyRepository familyRepository) {
        return (args) -> {
            // save a couple of customers
            String password = new BCryptPasswordEncoder().encode("1111");
            User userAdmin = new User("admin", "mtol@gmail.ua");
            userAdmin.setRole(UserRole.ADMIN);
            userAdmin.setPassword(password);
            repository.save(userAdmin);

            User user234 = repository.findOneByEmail("mtol@gmail.ua").get();
            System.out.println(user234);

            repository.save(new User("Jack", "Bauer"));
            repository.save(new User("Chloe", "O'Brian"));
            repository.save(new User("Kim", "Bauer"));
            repository.save(new User("David", "Palmer"));
            repository.save(new User("Michelle", "Dessler"));
            User andriy = new User("Andry", "asdfasdf@mail.py");
            List<Expense> expenses = new ArrayList<>();
            expenses.add(new Expense(23., "food" , andriy) );
            expenses.add(new Expense(23., "coffee" , andriy) );

            andriy.setExpenses(expenses);
            // ger andy
            andriy = repository.save(andriy);
            System.out.println(andriy);
            List<Expense> expenses1 = andriy.getExpenses();
            expenses1.forEach(System.out::println);

             // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (User user : repository.findAll()) {
                log.info(user.toString());
            }
            log.info("");

            // fetch an individual User by ID
            User user = repository.findOne(1L);
            log.info("User found with findOne(1L):");
            log.info("--------------------------------");
            log.info(user.toString());
            log.info("");

            // fetch customers by last name
            log.info("User found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            for (User bauer : repository.findByEmail("Bauer")) {
                log.info(bauer.toString());
            }
            log.info("");
            Category category = categoryRepository.save(new Category("cinema"));
            Expense expense = new Expense(34. , "food", user);
            Expense expense2 = new Expense(37. , "food", user);
            Expense expense3 = new Expense(100.45 , "food", user);
            expense.setCreationTime(new Date());
            expense2.setCreationTime(new Date());
            expense3.setCreationTime(new Date());
            expense.addCategory(category);
            expense2.addCategory(category);
            expense3.addCategory(category);

            expenseRepository.save(expense);
            expenseRepository.save(expense2);
            expenseRepository.save(expense3);
            log.info(category.toString());
            log.info(expense.toString());

            Family family = new Family();
            family.setName("My Family");
            family.addUser(user);
            familyRepository.save(family);
            System.out.println(family);
        };
    }

}