package com.example.afnanex.Service;

import com.example.afnanex.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {
    ArrayList<Teacher> teachers = new ArrayList<>();

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public boolean update(Teacher teacher, String IdTeacher) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getIdTeacher().equals(IdTeacher)) {
                teachers.set(i, teacher);
                return true;
            }
        }
        return false;
    }

    public boolean delete(String IdTeacher) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getIdTeacher().equals(IdTeacher)) {
                teachers.remove(i);
                return true;
            }

        }
        return false;

    }

    public boolean returnsTeacher(Teacher teacher, String IdTeacher) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getIdTeacher().equals(IdTeacher)) {
                return true;
            }

        }
        return false;
    }
}