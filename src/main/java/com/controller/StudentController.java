package com.controller;

import com.pojo.Student;
import com.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;
    private static final Logger log= LogManager.getLogger(StudentController.class);

    //student,body
    @RequestMapping(value = "/students",method = RequestMethod.GET)
    public String count(Model model){
        int working = studentService.countStudent(1);
        int learning = studentService.countStudent(0);
        List<Student> studentList = studentService.findStudent();
        List<Integer> integerList;
        model.addAttribute("item","body");
        model.addAttribute("working",working);
        model.addAttribute("learning",learning);
        model.addAttribute("studentList",studentList);
        log.error(studentList);
        return "myView";
    }

    //student,body
    @RequestMapping(value = "/noHF",method = RequestMethod.GET)
    public String noHF(Model model){
        int working = studentService.countStudent(1);
        int learning = studentService.countStudent(0);
        List<Student> studentList = studentService.findStudent();
        List<Integer> integerList;
        model.addAttribute("item","body");
        model.addAttribute("working",working);
        model.addAttribute("learning",learning);
        model.addAttribute("studentList",studentList);
        log.error(studentList);
        return "secondView";
    }
}
