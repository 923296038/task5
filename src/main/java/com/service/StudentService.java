package com.service;

import com.pojo.Student;

import java.util.List;

public interface StudentService {
    int countStudent(int status);
    List<Student> findStudent();
}
