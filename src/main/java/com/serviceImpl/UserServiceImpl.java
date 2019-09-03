package com.serviceImpl;

import com.mapper.UserMapper;
import com.pojo.User;
import com.service.UserService;
import com.util.EncodeUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    String salt = null;
    private static final Logger log = LogManager.getLogger(UserServiceImpl.class);
    EncodeUtil util = new EncodeUtil();
    @Override
    public boolean granted(User user) {
        /*User user1 = userMapper.findByUsername(user.getUsername());
        boolean flag = userMapper.countByUsername(user.getUsername())>0;
        //首先判断用户名是否存在
        boolean flag1 = user.getPassword().equals(user1.getPassword()) ? true:false;
        log.error("exist?:"+flag+";matches?:"+flag1);
        if(flag && flag1){return true;}
        else return false;*/
        if(userMapper.countByUsername(user.getUsername())>0){
            String salt = user.getPassword();
            String cur_md5 = util.MD5Util(user.getPassword()+salt);
            log.error("你输入密码的md5: "+cur_md5);
            String pre_md5 = userMapper.findByUsername(user.getUsername());
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
    public String findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public int insertAUser(User user) {
        String salt = user.getPassword();
        user.setPassword_md5(util.MD5Util(user.getPassword()+salt));
        return userMapper.insertAUser(user);
    }
}
