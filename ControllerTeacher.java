package com.example.afnanex.Controller;

import com.example.afnanex.ApiRespons.ApiRespons;
import com.example.afnanex.Model.Student;
import com.example.afnanex.Model.Teacher;
import com.example.afnanex.Service.StudentService;
import com.example.afnanex.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/Teacher")
@RequiredArgsConstructor
public class ControllerTeacher {
    private final TeacherService teacherService;


    @GetMapping("/get")
    public ResponseEntity getTeacher(){
        ArrayList<Teacher> teachers=teacherService.getTeachers();
        return ResponseEntity.status(200).body(teachers);
    }
    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiRespons("add Teacher"));
    }
    @PutMapping("/update/{IdTeacher}")
    public ResponseEntity update(@RequestBody @Valid Teacher teacher,@PathVariable String IdTeacher, Errors errors){
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdate= teacherService.update(teacher,IdTeacher);
        if (isUpdate){
            return ResponseEntity.status(200).body(new ApiRespons("update Teacher "));

        }
        return ResponseEntity.status(400).body(new ApiRespons("not found ID Teacher "));
    }
    @DeleteMapping("/delete/{IdTeacher}")
    public ResponseEntity delete(@PathVariable String IdTeacher){
        boolean isDelete= teacherService.delete(IdTeacher);
        if (isDelete){
            return ResponseEntity.status(200).body(new ApiRespons("delete Teacher"));
        }
        return ResponseEntity.status(400).body(new ApiRespons("not found Id Teacher"));
    }
    @PostMapping("/returnsTeacher/{IdTeacher}")
    public ResponseEntity returnsTeacher(@PathVariable String IdTeacher,Teacher teacher){
        boolean isreturnsTeacher= teacherService.returnsTeacher(teacher,IdTeacher);
        if (isreturnsTeacher){
            return ResponseEntity.status(200).body(new ApiRespons("return Teacher "));
        }
        return ResponseEntity.status(400).body(new ApiRespons("not found Id Teacher"));
        }
    }

