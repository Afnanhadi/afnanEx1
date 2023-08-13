package com.example.afnanex.Controller;

import com.example.afnanex.ApiRespons.ApiRespons;
import com.example.afnanex.Model.Student;
import com.example.afnanex.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/Students")
@RequiredArgsConstructor
public class ControllerStudents {
    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getStudents() {
        ArrayList<Student> students = studentService.getStudents();
        return ResponseEntity.status(200).body(students);
    }

    @PostMapping("/add")
    public ResponseEntity addStudents(@RequestBody @Valid Student student, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        studentService.addStudents(student);
        return ResponseEntity.status(200).body(new ApiRespons("Add Students"));
    }

    @PutMapping("/update/{NameStudent}")
    public ResponseEntity update(@RequestBody @Valid Student student, @PathVariable String NameStudent, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isupdate = studentService.update(student, NameStudent);
        if (isupdate) {
            return ResponseEntity.status(200).body(new ApiRespons("update Student"));
        }
        return ResponseEntity.status(400).body(new ApiRespons("not found name"));
    }


    @DeleteMapping("/delete/{IdStudent}")
    public ResponseEntity delete(@PathVariable String IdStudent) {
        boolean isDelete = studentService.delete(IdStudent);
        if (isDelete) {
            return ResponseEntity.status(200).body(new ApiRespons("delete Student"));
        }
        return ResponseEntity.status(400).body(new ApiRespons("not found Id student"));
    }

    @PostMapping("/returnsStudent/{NameStudent}")
    public ResponseEntity returnsStudent(@PathVariable String NameStudent, Student student) {
        boolean isreturnsStudent = studentService.returnsStudent(NameStudent, student);
        if (isreturnsStudent) {
            return ResponseEntity.status(200).body(new ApiRespons("one Student"));
        }
        return ResponseEntity.status(400).body(new ApiRespons("not found Name Student"));

    }
}
