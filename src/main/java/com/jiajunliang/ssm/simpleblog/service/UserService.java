package com.jiajunliang.ssm.simpleblog.service;

import com.jiajunliang.ssm.simpleblog.bean.User;

public interface UserService {

    /**
     * Retrieve user by id
     * @param id an integer
     * @return A User object contains user info
     */
    User getUserById(int id);

    /**
     * Retrieve user by username
     * @param userName a String
     * @return A User object contains user info
     */
    User getUserByUserName(String userName);

    /**
     * Register method
     * @param user Contains all information
     * @return An boolean number, true for register success, false for register failure
     */
    boolean register(User user);

    /**
     * Login method
     * @param userName string
     * @param userPassword string
     * @return A boolean value, true for login success, false for login failure
     */
    User login(String userName, String userPassword);

    /**
     * Check username whether exists
     * @param userName A string
     * @return A boolean value, true for username exists, false for username not exists
     */
    boolean existUserName(String userName);

    /**
     * Update user info
     * @param user Contains user info
     * @return A boolean value, true for update success, false for update failure
     */
    boolean updateUser(User user);

}
