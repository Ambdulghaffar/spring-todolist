package com.demo.springboot.master.springtodolist.mapper;

import com.demo.springboot.master.springtodolist.dto.TodoRequestDTO;
import com.demo.springboot.master.springtodolist.entities.TodoList;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TodoReqDTOMapper {
    TodoRequestDTO toDto(TodoList todoList);
    TodoList toEntity(TodoRequestDTO todoRequestDTO);
}
