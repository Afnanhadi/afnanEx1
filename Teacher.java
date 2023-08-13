package com.example.afnanex.Model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {
    @NotNull(message = "Id Teacher should not empty")
    private String IdTeacher;
    @NotNull(message = "Id Teacher should not empty")
    private String nameTeacher;
    @NotNull(message = "Id Teacher should not empty")
    private Double salary;
}
