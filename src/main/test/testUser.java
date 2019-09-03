import com.pojo.User;
import com.service.StudentService;
import com.service.UserService;
import com.util.EncodeUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.rmi.CORBA.Util;

public class testUser {
    private static final Logger log= LogManager.getLogger(testUser.class);
    EncodeUtil util = new EncodeUtil();
    ApplicationContext context=new
            ClassPathXmlApplicationContext("applicationContext.xml");
    UserService userService=
            (UserService) context.getBean("userService");

    @Test
    public void testFindByUsername(){
        String s = userService.findByUsername("wang");
        log.error(s);
    }
    @Test
    public void testInsert(){
        User user = new User();
        user.setUsername("chen");
        user.setPassword("888888");
        userService.insertAUser(user);
        log.error(user);
    }
    @Test
    //测试登录,username,password分别对应用户名和密码.
    //数据库中存在一条 wang 123456的数据
    public void testGranted(){
        User user = new User();
        user.setUsername("chen");
        user.setPassword("888888");
//        log.error("加盐md5 : "+util.MD5Util("123456"+"123456"));
        boolean flag = userService.granted(user);
    }
}

