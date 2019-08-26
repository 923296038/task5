package com.serviceImpl;

import com.mapper.StudentMapper;
import com.pojo.Student;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.sasl.SaslServer;
import java.util.List;

@Service(value = "studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;
    @Override
    public int countStudent(int status) {
        return studentMapper.countStudent(status);
    }

    @Override
    public List<Student> findStudent() {
        return studentMapper.findStudent();
    }
}
