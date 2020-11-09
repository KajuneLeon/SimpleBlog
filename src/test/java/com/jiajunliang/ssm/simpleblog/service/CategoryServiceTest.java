package com.jiajunliang.ssm.simpleblog.service;

import com.jiajunliang.ssm.simpleblog.bean.Category;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class CategoryServiceTest {

    public static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");

    public static CategoryService categoryService = applicationContext.getBean("categoryServiceImpl", CategoryService.class);

    @Test
    public void getAllFirstCategory() {
        categoryService.getAllFirstCategory().forEach(System.out::println);
    }

    @Test
    public void getAllCategory() {
        categoryService.getAllCategory().forEach(System.out::println);
    }

    @Test
    public void getCategoryById() {
        System.out.println(categoryService.getCategoryById(9));
    }

    @Test
    public void updateCategory() {
        Category category = categoryService.getCategoryById(9);
        category.setCategoryName("Tomcat&Servlet");
        System.out.println(categoryService.updateCategory(category));
    }

    @Test
    public void getFirstAndSecondCategoryIdById() {
        System.out.println(categoryService.getFirstAndSecondCategoryIdById(1));
        System.out.println(categoryService.getFirstAndSecondCategoryIdById(2));
        System.out.println(categoryService.getFirstAndSecondCategoryIdById(4));
    }

    @Test
    public void addCategory() {
        Category category = new Category();
        category.setCategoryPId(10);
        category.setCategoryName("SpringMVC");
        System.out.println(categoryService.addCategory(category));
    }

    @Test
    public void deleteCategoryById() {
        System.out.println(categoryService.deleteCategoryById(10));
    }
}