package com.example.repository;

import com.example.models.Todo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoRepositoryImpl implements ITodoRepository{
    @Override
    public List<Todo> findAll() {
        return null;
    }

    @Override
    public Todo findById(int id) {
        return new Todo(id,null,null);
    }
}
