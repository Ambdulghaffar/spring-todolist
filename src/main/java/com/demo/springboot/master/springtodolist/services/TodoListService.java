package com.demo.springboot.master.springtodolist.services;

import com.demo.springboot.master.springtodolist.dto.TodoRequestDTO;
import com.demo.springboot.master.springtodolist.dto.TodoResponseDTO;
import com.demo.springboot.master.springtodolist.entities.TodoList;
import com.demo.springboot.master.springtodolist.mapper.TodoReqDTOMapper;
import com.demo.springboot.master.springtodolist.mapper.TodoRespDTOMapper;
import com.demo.springboot.master.springtodolist.repository.TodoListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoListService implements TodoListServiceImpl {

    private final TodoListRepository todoListRepository;
    private final TodoReqDTOMapper todoReqDTOMapper;
    private final TodoRespDTOMapper todoRespDTOMapper;
    public TodoListService(TodoListRepository todoListRepository, TodoReqDTOMapper todoReqDTOMapper, TodoRespDTOMapper todoRespDTOMapper) {
        this.todoListRepository = todoListRepository;
        this.todoReqDTOMapper = todoReqDTOMapper;
        this.todoRespDTOMapper = todoRespDTOMapper;
    }


    @Override
    public TodoList CreateTodoList(TodoRequestDTO todoRequestDTO) {
        // Convert DTO to entity, save and return saved entity (id and timestamps generated automatically)
        TodoList todoList = todoReqDTOMapper.toEntity(todoRequestDTO);
        return todoListRepository.save(todoList);
    }

    @Override
    public TodoList UpdateTodoList(Integer id, TodoRequestDTO todoRequestDTO) {
        // Find existing entity
        TodoList existing = todoListRepository.findById(id).orElse(null);
        if (existing == null) {
            throw new RuntimeException("TodoList not found with id: " + id);
        }
        // Update mutable fields from DTO
        existing.setTitle(todoRequestDTO.getTitle());
        existing.setDescription(todoRequestDTO.getDescription());
        // Save and return updated entity
        return todoListRepository.save(existing);
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
    public TodoResponseDTO GetTodoListById(Integer id) {
        TodoList todoList = todoListRepository.findById(id).orElse(null);
        if (todoList == null) {
            throw new RuntimeException("TodoList not found" );
        }
        return todoRespDTOMapper.toDto(todoList);
    }

    @Override
    public List<TodoResponseDTO> GetAllTodoLists(String order) {
        List<TodoList> lists;
        if(order!=null && order.equalsIgnoreCase("desc")){
            lists = todoListRepository.findAllByOrderByIdDesc();
        } else {
            lists = todoListRepository.findAll();
        }

        return lists.stream()
                .map(todoRespDTOMapper::toDto)
                .collect(Collectors.toList());
    }

}
