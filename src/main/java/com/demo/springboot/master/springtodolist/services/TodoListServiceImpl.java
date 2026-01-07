package com.demo.springboot.master.springtodolist.services;

import com.demo.springboot.master.springtodolist.dto.TodoRequestDTO;
import com.demo.springboot.master.springtodolist.dto.TodoResponseDTO;
import com.demo.springboot.master.springtodolist.entities.TodoList;

import java.util.List;

public interface TodoListServiceImpl {
    TodoList CreateTodoList(TodoRequestDTO todoRequestDTO);
    TodoList UpdateTodoList(Integer id, TodoRequestDTO todoRequestDTO);
    void DeleteTodoList(Integer id);
    TodoResponseDTO GetTodoListById(Integer id);
    List<TodoResponseDTO> GetAllTodoLists(String order);
}
