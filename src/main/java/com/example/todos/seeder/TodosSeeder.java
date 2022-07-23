package com.example.todos.seeder;

import com.example.todos.model.Todo;
import com.example.todos.repository.TodosRepositoryREST;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class TodosSeeder implements Seeder<TodosRepositoryREST> {
    @Override
    @Bean
    public CommandLineRunner run(TodosRepositoryREST repository) {
        return (args) -> {
            repository.save(new Todo("ciao", "ciao1"));
            repository.save(new Todo("ciao", "ciao2"));
            repository.save(new Todo("ciao1", "ciao3"));
        };
    }
}
