package com.serviceImpl;

import com.mapper.UserMapper;
import com.pojo.User;
import com.service.UserService;
import com.util.EncodeUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    String salt = null;
    private static final Logger log = LogManager.getLogger(UserServiceImpl.class);
    EncodeUtil util = new EncodeUtil();
    @Override
    /*账密校验*/
    public boolean granted(User user) {
        /*User user1 = userMapper.findByUsername(user.getUsername());
        boolean flag = userMapper.countByUsername(user.getUsername())>0;
        //首先判断用户名是否存在
        boolean flag1 = user.getPassword().equals(user1.getPassword()) ? true:false;
        log.error("exist?:"+flag+";matches?:"+flag1);
        if(flag && flag1){return true;}
        else return false;*/
        if(userMapper.countByUsername(user.getUser_name())>0){
            String salt = userMapper.getSalt(user.getUser_name());
            String cur_md5 = util.MD5Util(user.getPassword()+salt);
            log.error("你输入密码的md5: "+cur_md5);
            String pre_md5 = userMapper.findByUsername(user.getUser_name());
            log.error("   原密码的md5:  "+pre_md5);
            boolean flag = pre_md5.equals(cur_md5)?true:false;
            log.error("是否相等?"+flag);
            if (pre_md5.equals(cur_md5)){
                return true;
            }
            else return false;
        }
        else return false;
    }

    @Override
    public String findByUsername(String user_name) {
        return userMapper.findByUsername(user_name);
    }

    @Override
    public String getSalt(String user_name) {
        return userMapper.getSalt(user_name);
    }

    /*用户注册*/
    @Override
    public int insertAUser(User user) {
        String salt = util.getRandomString(12);
        user.setSalt(salt);
        user.setPassword_md5(util.MD5Util(user.getPassword()+salt));
        String current_date=null;
        /*时间戳>带格式时间字符串*/
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long time_in_mills = System.currentTimeMillis();
        Date date = new Date(time_in_mills);
        current_date = simpleDateFormat.format(date);

        user.setCreate_at(current_date);
        if (user.getPassword().equals(user.getPassword_repeat())){
            log.error("两次输入密码匹配");
            return userMapper.insertAUser(user);
        }
        else {
            log.error("两次输入不匹配");
            return 0;
        }
    }

    @Override
    public int findIdByUserName(String user_name) {
        return userMapper.findIdByUserName(user_name);
    }

    @Override
    public boolean user_dupli(String username) {
        return (userMapper.countByUsername(username)>0?true:false);
    }

    @Override
    public boolean verify(int id) {
        return (userMapper.verify(id)==1);
    }
}
