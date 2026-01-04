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
    public void run(String... args) throws Exception {

        if(todoListRepository.count()==0){
            List<TodoList> todoLists =  List.of(
                    new TodoList("Acheter des courses", "Acheter du pain, du lait et des œufs", "2024-06-10"),
                    new TodoList("Aller à la salle de sport", "Séance de musculation à 18h", "2024-06-11"),
                    new TodoList("Préparer la présentation", "Finaliser les diapositives pour la réunion de lundi", "2024-06-12")
            );
            todoListRepository.saveAll(todoLists);
        }
    }
}
