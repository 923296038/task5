package com.service;

import com.pojo.User;

public interface UserService{
    boolean granted(User user);
    String findByUsername(String user_name);
    String getSalt(String user_name);
    int insertAUser(User user);
    int findIdByUserName(String user_name);
    boolean user_dupli(String username);

    boolean verify(int id);
}
