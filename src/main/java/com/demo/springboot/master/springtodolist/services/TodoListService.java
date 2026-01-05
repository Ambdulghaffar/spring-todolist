package com.demo.springboot.master.springtodolist.services;

import com.demo.springboot.master.springtodolist.entities.TodoList;
import com.demo.springboot.master.springtodolist.repository.TodoListRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoListService implements TodoListServiceImpl {

    private final TodoListRepository todoListRepository;
    public TodoListService(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public TodoList CreateTodoList(TodoList todoList) {
        return todoListRepository.save(todoList);
    }

    @Override
    public TodoList UpdateTodoList(Integer id, TodoList todoList) {
        TodoList todoListUpdate = todoListRepository.findById(id).orElse(null);
        if (todoListUpdate == null) {
            throw new RuntimeException("TodoList not found with id: " + id);
        }
        todoListUpdate.setTitle(todoList.getTitle());
        todoListUpdate.setDescription(todoList.getDescription());
        return todoListRepository.save(todoListUpdate);
    }

    @Override
    public void DeleteTodoList(Integer id) {
        TodoList todoListDelete = todoListRepository.findById(id).orElse(null);
        if (todoListDelete == null) {
            throw new RuntimeException("TodoList not found" );
        }
        todoListRepository.deleteById(id);
    }

    @Override
    public TodoList GetTodoListById(Integer id) {
        TodoList todoList = todoListRepository.findById(id).orElse(null);
        if (todoList == null) {
            throw new RuntimeException("TodoList not found" );
        }
        return todoList;
    }

    @Override
    public List<TodoList> GetAllTodoLists() {
        return todoListRepository.findAll();
    }
}
