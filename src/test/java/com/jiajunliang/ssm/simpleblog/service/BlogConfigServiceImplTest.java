package com.jiajunliang.ssm.simpleblog.service;

import com.jiajunliang.ssm.simpleblog.bean.BlogConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class BlogConfigServiceImplTest {

    public static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");

    public static BlogConfigService blogConfigService = applicationContext.getBean("blogConfigServiceImpl", BlogConfigService.class);

    @Test
    public void getLatestBlogConfig() {
        System.out.println(blogConfigService.getLatestBlogConfig());
    }

    @Test
    public void saveBlogConfig() {
        BlogConfig blogConfig = blogConfigService.getLatestBlogConfig();
        System.out.println(blogConfig);
        blogConfig.setBlogDescript("Changed descript in service");
        blogConfigService.saveBlogConfig(blogConfig);
        System.out.println(blogConfigService.getLatestBlogConfig());
    }
}