package com.languageschool.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartLanguageLabApplication {

    public static void main(String[] args) {

        SpringApplication.run(StartLanguageLabApplication.class, args);
    }

    // init bean to insert 3 courses into mysql database.
    /*@Bean
    CommandLineRunner initDatabase(CourseRepository repository) {
        return args -> {
            repository.save(new Course("A Guide to the Bodhisattva Way of Life", "Santideva", new BigDecimal("15.41")));
            repository.save(new Course("The Life-Changing Magic of Tidying Up", "Marie Kondo", new BigDecimal("9.69")));
            repository.save(new Course("Refactoring: Improving the Design of Existing Code", "Martin Fowler", new BigDecimal("47.99")));
        };
    }*/
}
