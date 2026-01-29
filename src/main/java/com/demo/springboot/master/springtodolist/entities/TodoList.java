package com.demo.springboot.master.springtodolist.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class TodoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;

    @Column(nullable = false, updatable = false)
    private Instant createdAt;
    @Column(nullable = false)
    private Instant updatedAt;

    @PrePersist
    public void onCreate() {
        Instant now = Instant.now();
        this.createdAt = now;
        this.updatedAt = now;
    }
    @PreUpdate
    public void onUpdate() {
        this.updatedAt = Instant.now();
    }


    public TodoList(String title, String description) {
        this.title = title;
        this.description = description;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }
}
