package com.jiajunliang.ssm.simpleblog.service;

import com.jiajunliang.ssm.simpleblog.bean.User;
import com.jiajunliang.ssm.simpleblog.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UserServiceImplTest {

    public static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");

    public static UserService userService = applicationContext.getBean("userServiceImpl", UserService.class);

    @Test
    public void register() {
        User user = new User();
        user.setUserName("admin");
        user.setUserPassword("123456");
        System.out.println(userService.register(user));
        System.out.println(userService.register(user));
    }

    @Test
    public void login() {
        System.out.println(userService.login("liangjiajun", "1234561"));
        System.out.println(userService.login("admin", "1123"));
    }

    @Test
    public void existUserName() {
        System.out.println(userService.existUserName("liangjiajun"));
        System.out.println(userService.existUserName("test"));
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setUserId(21);
        user.setUserName("admin");
        user.setUserPassword("123456");
        user.setUserEmail("new added email2233");
        System.out.println(userService.updateUser(user));
        user.setUserId(2);
        System.out.println(userService.updateUser(user));
    }
}