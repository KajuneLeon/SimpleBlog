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
    private UserDao userDao;

    @Override
    public User getUserById(int id) {
        return userDao.queryByUserId(id);
    }

    @Override
    public User getUserByUserName(String userName) {
        return userDao.queryByUsername(userName);
    }

    @Override
    public boolean register(User user) {
        // check userName whether exists
        if (existUserName(user.getUserName())) {
            return false;
        }
        return userDao.insertUser(user) != 0;
    }

    @Override
    public User login(String userName, String userPassword) {
        return userDao.queryByUserNameAndPassword(userName, userPassword);
    }

    @Override
    public boolean existUserName(String userName) {
        return userDao.queryByUsername(userName) != null;
    }

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
