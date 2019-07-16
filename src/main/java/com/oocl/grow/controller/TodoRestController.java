package com.oocl.grow.controller;


import com.oocl.grow.model.Todo;
import com.oocl.grow.repository.TodoRepository;
import com.oocl.grow.service.TodoService;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class TodoRestController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/todos")
    public List<Todo> getAllTodos(){
        return todoService.findAllTodos();
    }
}
