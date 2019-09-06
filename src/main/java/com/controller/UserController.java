package com.controller;

import com.pojo.User;
import com.service.UserService;
import com.util.DesUtil;
import com.util.Token_util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    Token_util token_util = new Token_util();
    @Autowired
    DesUtil desUtil ;
    private static final Logger log= LogManager.getLogger(UserController.class);

    @RequestMapping(value = "/toLogin")
    public String toL(){
        return "login";
    }
    /*
    * 登录方法
    * 输入账密>匹配数据库通过>签发token>
    * 存入cookie>拦截器检验token通过>/u/majors
    * */
    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request,User user, Model model, HttpSession session,HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8;pageEncoding=UTF-8");
        response.setCharacterEncoding("UTF-8");
        log.error(user.getUser_name());
        Cookie[] cookies0 = request.getCookies();
        /*
        登录验证
        */
        if (userService.granted(user)){
            //根据用户名获取到用户id
            int id = userService.findIdByUserName(user.getUser_name());
            SimpleDateFormat formate = new SimpleDateFormat("yyyy年MM月dd日HH时mm分");
            String time_in_format = formate.format(new Date(System.currentTimeMillis()));
            /*
            签发token,写入cookie
            */
            String token = id+"/"+time_in_format;
            log.error("生成的token: "+token);
            String token_encrypt = desUtil.encrypt(token);
            log.error("token加密: "+token_encrypt);
            Cookie cookie = new Cookie("token", token_encrypt);
            response.addCookie(cookie);
            /*
            * token写入session
            * */
            session.setAttribute("token", token_util.sign(id));
            return "redirect:/u/majors";
        }
        model.addAttribute("msg","登录失败:账号不存在|密码错误");
        return "login";
    }
    /*
    * 前往注册
    * */
    @RequestMapping(value = "/toNewUser",method = RequestMethod.GET)
    public String toNewUser(){
        return "newUser";
    }
    /*
    *注册
    * */
    @RequestMapping(value = "newUser",method = RequestMethod.POST)
    public String newUser(Model model, @Validated User user, BindingResult bindingResult){
        log.error("执行了这个方法");
        if (bindingResult.hasErrors()||userService.user_dupli(user.getUser_name())){
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            model.addAttribute("allErrors",allErrors);
            if (userService.user_dupli(user.getUser_name()))
                model.addAttribute("dupliErrors","用户名已被注册,请重试");
            for (ObjectError objectError:allErrors){
                log.error(objectError.getDefaultMessage());
            }
            return "errors";
        }
        userService.insertAUser(user);
        return "login";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request,HttpServletResponse response,HttpSession session){
        Cookie[] cookies0 = request.getCookies();
        if (cookies0 != null){
                Cookie[] cookies = request.getCookies();
                for (Cookie cookie : cookies){
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
                for (Cookie cookie:cookies){
                    log.error("执行了清除后 : "+cookie.getName()+cookie.getValue());
                }
        }
        session.invalidate();
        return "/login";
    }
}
