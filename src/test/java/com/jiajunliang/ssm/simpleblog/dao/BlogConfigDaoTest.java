package com.jiajunliang.ssm.simpleblog.dao;

import com.jiajunliang.ssm.simpleblog.bean.BlogConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class BlogConfigDaoTest {

    public static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");

    public static BlogConfigDao blogConfigDao = applicationContext.getBean("blogConfigDao", BlogConfigDao.class);

    @Test
    public void queryBlogConfigById() {
        System.out.println(blogConfigDao.queryBlogConfigById(1));
        System.out.println(blogConfigDao.queryBlogConfigById(2));
        System.out.println(blogConfigDao.queryBlogConfigById(3));
    }

    @Test
    public void queryLatestBlogConfig() {
        System.out.println(blogConfigDao.queryLatestBlogConfig());
    }

    @Test
    public void updateBlogConfig() {
        BlogConfig blogConfig = blogConfigDao.queryLatestBlogConfig();
        blogConfig.setBlogDescript("Changed Descript22");
        blogConfigDao.updateBlogConfig(blogConfig);
        System.out.println(blogConfigDao.queryLatestBlogConfig());
    }

    @Test
    public void insertBlogConfig() {
        BlogConfig blogConfig = blogConfigDao.queryLatestBlogConfig();
        System.out.println(blogConfig);
        blogConfig.setBlogDescript("Insert Descript22");
        blogConfigDao.insertBlogConfig(blogConfig);
        System.out.println(blogConfigDao.queryLatestBlogConfig());
    }

    @Test
    public void deleteBlogConfigById() {
        System.out.println(blogConfigDao.deleteBlogConfigById(4));
    }
}