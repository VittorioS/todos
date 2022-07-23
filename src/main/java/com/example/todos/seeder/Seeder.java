package com.example.todos.seeder;

import org.springframework.boot.CommandLineRunner;

public interface Seeder<T> {
    CommandLineRunner run(T repository);
}
