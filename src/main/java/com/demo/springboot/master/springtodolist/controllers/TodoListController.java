package com.demo.springboot.master.springtodolist.controllers;

import com.demo.springboot.master.springtodolist.entities.TodoList;
import com.demo.springboot.master.springtodolist.repository.TodoListRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/todolists")
public class TodoListController {

    private final TodoListRepository todoListRepository;
    public TodoListController(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @GetMapping
    public List<TodoList> findAll() {
        return todoListRepository.findAll();
    }

}
