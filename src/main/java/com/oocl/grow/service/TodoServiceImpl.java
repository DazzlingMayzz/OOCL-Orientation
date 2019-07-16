package com.oocl.grow.service;

import com.oocl.grow.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    @Override
    public List<Todo> findAllTodos() {
        List<Todo> todos = new ArrayList<>();
        todos.add(new Todo("123",false));
        todos.add(new Todo("456",true));

        return todos;
    }
}
