package com.jiajunliang.ssm.simpleblog.service;

import com.jiajunliang.ssm.simpleblog.bean.Article;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class ArticleServiceImplTest {

    public static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");

    public static ArticleService articleService = applicationContext.getBean("articleServiceImpl", ArticleService.class);

    @Test
    public void getArticleById() {
        System.out.println(articleService.getArticleById(1));
    }

    @Test
    public void getAllArticles() {
        articleService.getAllArticles().forEach(System.out::println);
    }

    @Test
    public void getArticlesByCategoryId() {
        System.out.println(articleService.getArticlesByCategoryId(2));
    }

    @Test
    public void getArticlesIssued() {
        articleService.getArticlesIssued().forEach(System.out::println);
    }

    @Test
    public void countArticleByCategoryId() {
        System.out.println(articleService.countArticleByCategoryId(2));
    }

    @Test
    public void getIssuedArticlesByCategoryId() {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        articleService.getIssuedArticlesByCategoryIds(list).forEach(System.out::println);
    }

    @Test
    public void updateArticle() {
        Article article = articleService.getArticleById(1);
        article.setArticleDate(new Date());
        System.out.println(articleService.updateArticle(article));
    }

    @Test
    public void addArticle() {
        Article article = new Article();
        article.setArticleTitle("title5");
        article.setArticleContentHTML("html5");
        article.setArticleContentMD("md5");
        article.setArticleStatus(0);
        article.setArticleDate(new Date());
        article.setArticleCategoryId(2);
        System.out.println(articleService.addArticle(article));
    }

    @Test
    public void deleteArticleById() {
        System.out.println(articleService.deleteArticleById(7));
    }
}