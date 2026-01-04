package com.demo.springboot.master.springtodolist.controllers;

import com.demo.springboot.master.springtodolist.entities.TodoList;
import com.demo.springboot.master.springtodolist.services.TodoListService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todolists")
public class TodoListController {

    private final TodoListService todoListService;
    public TodoListController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @PostMapping
    public TodoList createTodoList(@RequestBody TodoList todoList) {
        return todoListService.CreateTodoList(todoList);
    }

    @PutMapping("/{id}")
    public TodoList updateTodoList(@PathVariable Integer id, @RequestBody TodoList todoList) {
        return todoListService.UpdateTodoList(id, todoList);
    }

    @DeleteMapping("/{id}")
    public void deleteTodoList(@PathVariable Integer id) {
        todoListService.DeleteTodoList(id);
    }

    @GetMapping("/{id}")
    public TodoList getTodoListById(@PathVariable Integer id) {
        return todoListService.GetTodoListById(id);
    }

    @GetMapping
    public List<TodoList> getAllTodoLists() {
        return todoListService.GetAllTodoLists();
    }


}
