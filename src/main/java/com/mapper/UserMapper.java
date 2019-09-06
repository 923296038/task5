package com.mapper;

import com.pojo.User;

public interface UserMapper {
    int countByUsername(String user_name);
    String findByUsername(String user_name);
    String getSalt(String user_name);
    int insertAUser(User user);
    int findIdByUserName(String user_name);

    int verify(int id);
}
