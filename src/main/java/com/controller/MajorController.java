package com.controller;

import com.pojo.Major;
import com.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MajorController {
    @Autowired
    MajorService majorService;

    @RequestMapping(value = "/body1",method = RequestMethod.GET)
    public String major(Model model){
        List<Major> majorList = majorService.findMajor();
        model.addAttribute(majorList);
        return "page1";
    }

}
