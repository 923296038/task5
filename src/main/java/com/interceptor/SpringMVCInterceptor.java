package com.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SpringMVCInterceptor implements HandlerInterceptor {
    /*
    * 返回true继续,返回false终止
    * */
    @Override
    public boolean preHandle
    (HttpServletRequest request,
     HttpServletResponse response, Object handler) throws Exception {
        return false;
    }

    /*
    * 上一步返回true才执行↓
    * controller之后执行,视图层渲染前
    * */
    @Override
    public void postHandle
    (HttpServletRequest request,
     HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /*
    * 视图渲染后执行.
    * 作用是清理资源
    * */
    @Override
    public void afterCompletion
    (HttpServletRequest request,
     HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
