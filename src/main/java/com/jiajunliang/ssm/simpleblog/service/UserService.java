package com.jiajunliang.ssm.simpleblog.service;

import com.jiajunliang.ssm.simpleblog.bean.User;

public interface UserService {

    User getUserById(int id);

    User getUserByUserName(String userName);

    boolean register(User user);

    User login(String userName, String userPassword);

    boolean existUserName(String userName);

    boolean updateUser(User user);

}
