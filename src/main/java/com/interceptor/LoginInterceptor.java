package com.interceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    private static final Logger log = LogManager.getLogger(LoginInterceptor.class);

    @Override
    //该方法在处理请求前调用,负责一些前置初始化操作或对当前请求的预处理,如登陆检查
    //返回true继续调用下一个interceptor的preHandle或当前请求的Controller
    //返回false,请求结束,后续的interceptor和controller都不再执行
    //springMVC中的Interceptor拦截器是链式的，可以同时存在多个Interceptor，
    //然后SpringMVC会根据声明的前后顺序一个接一个的执行，而且所有的Interceptor中的preHandle方法都会在
    //Controller方法调用之前调用。
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        //获取请求的url
        String url = request.getRequestURI();
        if(url.indexOf("toLogin") >=0 || url.indexOf("/login") >=0){
            return true;
        }
        //获取session
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("user");
        if(obj != null)
            return true;
        request.setAttribute("msg","未登录.请登录");
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }

    @Override
    //当前请求进行处理之后,也就是controller方法调用后执行,但在渲染视图前.因此可以
    //在这个方法中对controller处理之后的modelAndView对象进行操作.
    //先声明的postHandle方法反而会后执行.
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //todo auto-generated method stub
    }

    @Override
    //整个请求处理完毕后回调,即在视图渲染完毕后.作用是进行资源局清理
    // 类似于try-catch-finally中的finally
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //todo auto-generated method stub
    }
}
