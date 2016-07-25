package com.mtol.checker;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mtol.checker.entity.Category;
import com.mtol.checker.entity.Expense;
import com.mtol.checker.entity.User;
import com.mtol.checker.entity.UserRole;
import com.mtol.checker.repository.ExpenseRepository;
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
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);


    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        System.out.println("Let's inspect the beans provided by Spring Boot:");

//        String[] beanNames = ctx.getBeanDefinitionNames();
//        Arrays.sort(beanNames);
//        for (String beanName : beanNames) {
//            System.out.println(beanName);
//        }
    }

    @Bean
    public CommandLineRunner demo(UserRepository repository, ExpenseRepository expenseRepository) {
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
            BigDecimal bigDecimal = new BigDecimal(23);
            expenses.add(new Expense(bigDecimal, "food" , andriy) );
            expenses.add(new Expense(bigDecimal, "coffee" , andriy) );

//            expenseRepository.save(expenses);
            andriy.setExpenses(expenses);
            // ger andy
            andriy = repository.save(andriy);
            System.out.println(andriy);
            List<Expense> expenses1 = andriy.getExpenses();
            expenses1.forEach(expense -> System.out.println(expense));

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
        };
    }

}