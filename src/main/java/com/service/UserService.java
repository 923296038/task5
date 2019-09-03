package com.service;

import com.pojo.User;

public interface UserService{
    boolean granted(User user);
    String findByUsername(String username);
    int insertAUser(User user);
}
