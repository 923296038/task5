package com.interceptor;

import com.service.UserService;
import com.util.DesUtil;
import com.util.Token_util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    UserService userService;
    Token_util token_util = new Token_util();
    @Autowired
    DesUtil desUtil;
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
        /*if(url.indexOf("toLogin") >=0 || url.indexOf("/login") >=0){
            return true;
        }*/
        boolean token_verify = false;
        boolean session_verify = false;

        /*
        cookie中判断token有效性
        取得名为token的cookie,获取id,查数据库有没有这个id
        */
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie:cookies){
            if(cookie.getName().equals("token")){
                String token_encrypt = cookie.getValue();
                log.error("解密前的token: "+token_encrypt);
                String token = desUtil.decrypt(token_encrypt);
                log.error(token);
                String id = token.substring(0,token.indexOf("/"));
                int id1 = Integer.parseInt(id);
                log.error(id1);
                if (userService.verify(id1))
                    token_verify = true;
//                byte[] id = jwt.getClaim("id").asString().getBytes();
//                log.error("jwt.getClaim:  "+id);
//                String id1 = new String(desUtil.decrypt(id));
//                log.error("decrypt:   "+id1);
//
//                log.error("获取到的id: "+id);
//                if(userService.verify(id1));
//                    token_verify = true;

//                String token = token_util.sign(4);
//                        DecodedJWT jwt = JWT.decode(token);
//
//                        log.error(jwt.getClaim("id").asString());
//
//                        String id_de = token_util.decrypt(jwt.getClaim("id").asString());
//                        log.error(id_de);
            }
//            else {
//                request.setAttribute("msg", "token检验未通过.");
//                request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
//                token_verify = false;
//            }
        }
        /*
        session中判断token有效性
        */
        /*HttpSession session = request.getSession();
        String token = (String) session.getAttribute("token");
        if(token_util.verify(token)) {
            session_verify = true;
        }
        log.error("cookie_token校验: "+token_verify+
                "   ;session_token校验: "+session_verify );*/

        if (token_verify){
            log.error("token verify succeed");
            return true;
        }
        else {
            request.setAttribute("msg", "token验证失败");
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
            return false;
        }
        //获取session
        /*HttpSession session = request.getSession();
        Object obj = session.getAttribute("user");
        if(obj != null)
            return true;
        request.setAttribute("msg","未登录.请登录");
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;*/
        //获取cookie
        /*Cookie[] cookies = request.getCookies();
        User user = new User();
        if(cookies != null){
            log.error("____________遍历cookie____________");
            for(Cookie cookie:cookies){
                log.error("cookies:"+cookie.getName()+" : "+cookie.getValue());
            }
            log.error("____________遍历cookie____________");

            for(Cookie cookie:cookies){
                user.setUsername(cookie.getName());
                user.setPassword_md5(cookie.getValue());
                boolean flag = userService.granted(user);
                log.error("cookie验证的结果"+flag);
                //验证cookie
                if (flag)
                    return true;
                request.setAttribute("msg","未登录.请登录");
                request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
                return false;
            }
        }
        request.setAttribute("msg","未登录.请登录");
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;*/
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
