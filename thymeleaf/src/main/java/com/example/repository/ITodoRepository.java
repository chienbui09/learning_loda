package com.example.repository;

import com.example.models.Todo;

import java.util.List;

public interface ITodoRepository {
    List<Todo> findAll();

    Todo findById(int id);
}
