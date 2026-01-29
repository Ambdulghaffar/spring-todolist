package com.demo.springboot.master.springtodolist.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodoRequestDTO {
    @NotBlank(message = "Le titre est obligatoire")
    @Size(min = 3, max = 100, message = "Le titre doit faire entre 3 et 100 caractères")
    private String title;

    @Size(max = 500, message = "La description ne doit pas dépasser 500 caractères")
    private String description;
}
