package com.example.afnanex.Service;

import com.example.afnanex.Model.Student;
import com.example.afnanex.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {
    ArrayList<Student> students = new ArrayList<>();


    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudents(Student student) {
        students.add(student);
    }

    public boolean update(Student student, String NameStudent) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getNameStudent().equals(NameStudent)) {
                students.set(i, student);
                return true;
            }
        }
        return false;
    }

    public boolean delete(String IdStudent) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getIdStudent().equals(IdStudent)) {
                students.remove(i);
                return true;
            }

        }
        return false;

    }

    public boolean returnsStudent(String NameStudent, Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getNameStudent().equals(NameStudent)){
                return true;
            }

        }
        return false;
    }
}