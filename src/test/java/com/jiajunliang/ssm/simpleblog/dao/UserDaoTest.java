package com.jiajunliang.ssm.simpleblog.dao;

import com.jiajunliang.ssm.simpleblog.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UserDaoTest {

    public static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");

    public static UserDao userDao = applicationContext.getBean("userDao", UserDao.class);

    @Test
    public void queryByUsername() {
        System.out.println(userDao.queryByUsername("liangjiajun"));
    }

    @Test
    public void queryByUsernameAndPassword() {
        System.out.println(userDao.queryByUsernameAndPassword("liangjiajun", "123456"));
    }

    @Test
    public void updateUser() {
        User user = userDao.queryByUsername("liangjiajun");
        user.setUserDescript("changed descript11");
        userDao.updateUser(user);
        System.out.println(userDao.queryByUsername("liangjiajun"));
    }

    @Test
    public void insertUser() {
        User user = userDao.queryByUsername("liangjiajun");
        user.setUserDescript("added descript");
        user.setUserName("ADD");
        userDao.insertUser(user);
        System.out.println(userDao.queryByUsername("ADD"));
    }

    @Test
    public void deleteUser() {
        userDao.deleteUser(12);
    }
}