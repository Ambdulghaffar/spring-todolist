package com.demo.springboot.master.springtodolist.services;

import com.demo.springboot.master.springtodolist.entities.TodoList;

import java.util.List;

public interface TodoListServiceImpl {
    TodoList CreateTodoList(TodoList todoList);
    TodoList UpdateTodoList(Integer id, TodoList todoList);
    void DeleteTodoList(Integer id);
    TodoList GetTodoListById(Integer id);
    List<TodoList> GetAllTodoLists();
}
