package com.demo.springboot.master.springtodolist.repository;

import com.demo.springboot.master.springtodolist.entities.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList,Integer> {
    List<TodoList> findAllByOrderByIdDesc();
    List<TodoList> findByTitleContainingIgnoreCase(String title);
}
