package com.jiajunliang.ssm.simpleblog.dao;

import com.jiajunliang.ssm.simpleblog.bean.Category;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class CategoryDaoTest {

    public static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");

    public static CategoryDao categoryDao = applicationContext.getBean("categoryDao", CategoryDao.class);

    @Test
    public void queryCategoryById() {
        System.out.println(categoryDao.queryCategoryById(1));
    }

    @Test
    public void queryAllCategory() {
        List<Category> categories = categoryDao.queryAllCategory();
        categories.forEach(System.out::println);
    }

    @Test
    public void queryAllFirstCategory() {
        List<Category> categories = categoryDao.queryAllFirstCategory();
        categories.forEach(System.out::println);
    }

    @Test
    public void updateCategory() {
        Category category = categoryDao.queryCategoryById(2);
        category.setCategoryName("对象和类");
        categoryDao.updateCategory(category);
    }

    @Test
    public void insertCategory() {
        Category category = new Category();
        category.setCategoryPId(4);
        category.setCategoryName("Tomcat");
        categoryDao.insertCategory(category);
    }

    @Test
    public void deleteCategoryById() {
        categoryDao.deleteCategoryById(6);
    }
}