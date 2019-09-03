package com.mapper;

import com.pojo.User;

public interface UserMapper {
    int countByUsername(String username);
    String findByUsername(String username);
    int insertAUser(User user);
}
