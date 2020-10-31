package com.jiajunliang.ssm.simpleblog.service;

import com.jiajunliang.ssm.simpleblog.bean.User;
import com.jiajunliang.ssm.simpleblog.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @project: SimpleBlog
 * @program: UserServiceImpl
 * @description: UserService implementation
 * @author: JIAJUN LIANG
 * @create: 2020-10-30 10:33
 **/
@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    /**
     * Retrieve user by id
     * @param id an integer
     * @return A User object contains user info
     */
    @Override
    public User getUserById(int id) {
        return userDao.queryByUserId(id);
    }

    /**
     * Retrieve user by username
     * @param userName a String
     * @return A User object contains user info
     */
    @Override
    public User getUserByUserName(String userName) {
        return userDao.queryByUsername(userName);
    }

    /**
     * Register method
     * @param user Contains all information
     * @return An boolean number, true for register success, false for register failure
     */
    @Override
    public boolean register(User user) {
        // check userName whether exists
        if (existUserName(user.getUserName())) {
            return false;
        }
        return userDao.insertUser(user) != 0;
    }

    /**
     * Login method
     * @param userName string
     * @param userPassword string
     * @return A boolean value, true for login success, false for login failure
     */
    @Override
    public User login(String userName, String userPassword) {
        return userDao.queryByUserNameAndPassword(userName, userPassword);
    }

    /**
     * Check username whether exists
     * @param userName A string
     * @return A boolean value, true for username exists, false for username not exists
     */
    @Override
    public boolean existUserName(String userName) {
        return userDao.queryByUsername(userName) != null;
    }

    /**
     * Update user info
     * @param user Contains user info
     * @return A boolean value, true for update success, false for update failure
     */
    @Override
    public boolean updateUser(User user) {
        // check userName whether is occupied with other user
        if (existUserName(user.getUserName())) {
            User tempUser = userDao.queryByUsername(user.getUserName());
            if (tempUser.getUserId() != user.getUserId()) {
                return false;
            }
        }
        return userDao.updateUser(user) != 0;
    }
}
