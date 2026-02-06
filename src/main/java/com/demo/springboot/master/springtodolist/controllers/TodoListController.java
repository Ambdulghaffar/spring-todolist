package com.demo.springboot.master.springtodolist.controllers;

import com.demo.springboot.master.springtodolist.dto.TodoRequestDTO;
import com.demo.springboot.master.springtodolist.dto.TodoResponseDTO;
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
    public TodoList createTodoList(@RequestBody TodoRequestDTO todoRequestDTO) {
        return todoListService.CreateTodoList(todoRequestDTO);
    }

    @PutMapping("/{id}")
    public TodoList updateTodoList(@PathVariable Integer id, @RequestBody TodoRequestDTO todoRequestDTO) {
        return todoListService.UpdateTodoList(id, todoRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTodoList(@PathVariable Integer id) {
        todoListService.DeleteTodoList(id);
    }

    @GetMapping("/{id}")
    public TodoResponseDTO getTodoListById(@PathVariable Integer id) {
        return todoListService.FindTodoListById(id);
    }

    @GetMapping
    public List<TodoResponseDTO> getAllTodoLists(@RequestParam(value = "order", required = false, defaultValue = "desc") String order) {
        return todoListService.FindAllTodoLists(order);
    }

    @GetMapping("/title")
    public List<TodoResponseDTO> findTodoListByTitle(@RequestParam(value = "title", defaultValue = "") String title) {
        return todoListService.FindTodoListByTitle(title);
    }


}
