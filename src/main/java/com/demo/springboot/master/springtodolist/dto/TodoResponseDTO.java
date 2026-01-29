package com.demo.springboot.master.springtodolist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodoResponseDTO {
    private Integer id;
    private String title;
    private String description;
    private Instant createdAt;
    private Instant updatedAt;
}
