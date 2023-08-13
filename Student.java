package com.example.afnanex.Model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    @NotNull(message = " Id should not empty")
    private String IdStudent;
    @NotNull(message = " Name student should not empty")
    public String nameStudent;
    @NotNull(message = " Age should not empty")
    private Integer age;
    @NotNull(message = " Major should not empty")
    private String major;

}
