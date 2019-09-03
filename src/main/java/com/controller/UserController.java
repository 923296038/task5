package com.controller;

import com.pojo.User;
import com.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    private static final Logger log= LogManager.getLogger(UserController.class);

    @RequestMapping(value = "/toLogin")
    public String toL(){
        return "login";
    }

    @RequestMapping(value = "/login")
    public String login(User user, Model model, HttpSession session){
        log.error(user.getUsername());
        if(userService.granted(user)){
            session.setAttribute("user",user);
            model.addAttribute("user",user);
            return "redirect:/u/majors";
            //登录后才能访问的职业页面
        }
        model.addAttribute("msg","用户名不存在|密码不匹配");
        return "login";
    }
    /*@RequestMapping(value = "/main")
    public String main(Model model){
        model.addAttribute("item","body1");
        return "redirect:/body1";
    }*/
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }
}
