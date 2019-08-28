package com.mapper;

import com.pojo.Student;

import java.util.List;

public interface StudentMapper {
    int countStudent(int status);
    List<Student> findStudent();

    int countByMI(int id);
}
