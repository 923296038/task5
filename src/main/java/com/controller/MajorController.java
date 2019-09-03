package com.controller;

import com.pojo.Major;
import com.service.MajorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.List;

@Controller
public class MajorController {
    @Autowired
    MajorService majorService;
    private static final Logger log = LogManager.getLogger(MajorController.class);

    @RequestMapping(value = "/u/majors")
    public String major(Model model) {
        List<Major> majorList = majorService.findMajor();
        log.error(majorList.size());
        for (int p = 1; p <= majorList.size(); p++) {
            boolean flag = majorService.updateLear(p);
        }
        model.addAttribute("item", "body1");
        model.addAttribute(majorList);
//        log.error(majorList);
        return "myView";
    }
}
