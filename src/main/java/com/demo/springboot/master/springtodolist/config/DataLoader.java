package com.demo.springboot.master.springtodolist.config;

import com.demo.springboot.master.springtodolist.entities.TodoList;
import com.demo.springboot.master.springtodolist.repository.TodoListRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final TodoListRepository todoListRepository;
    public DataLoader(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }
    @Override
    public void run(String... args) {

        if(todoListRepository.count()==0){
            List<TodoList> todoLists =  List.of(
                    new TodoList("Acheter des courses", "Acheter du pain, du lait et des œufs"),
                    new TodoList("Aller à la salle de sport", "Séance de musculation à 18h" ),
                    new TodoList("Préparer la présentation", "Finaliser les diapositives pour la réunion de lundi")
            );
            todoListRepository.saveAll(todoLists);
        }
    }
}
