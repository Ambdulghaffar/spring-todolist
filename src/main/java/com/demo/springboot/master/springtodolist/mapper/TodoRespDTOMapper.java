package com.demo.springboot.master.springtodolist.mapper;

import com.demo.springboot.master.springtodolist.dto.TodoResponseDTO;
import com.demo.springboot.master.springtodolist.entities.TodoList;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TodoRespDTOMapper {
    TodoResponseDTO toDto(TodoList todoList);
    TodoList toEntity(TodoResponseDTO todoResponseDTO);
}
