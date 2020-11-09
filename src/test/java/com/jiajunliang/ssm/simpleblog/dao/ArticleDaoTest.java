package com.jiajunliang.ssm.simpleblog.dao;

import com.jiajunliang.ssm.simpleblog.bean.Article;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class ArticleDaoTest {

    public static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");

    public static ArticleDao articleDao = applicationContext.getBean("articleDao", ArticleDao.class);


    @Test
    public void queryArticleById() {
        System.out.println(articleDao.queryArticleById(1));
    }

    @Test
    public void queryAllArticles() {
        articleDao.queryAllArticles().forEach(System.out::println);
    }

    @Test
    public void queryArticlesByCategoryId() {
        articleDao.queryArticlesByCategoryId(2).forEach(System.out::println);
        System.out.println(articleDao.queryArticlesByCategoryId(4));
    }

    @Test
    public void queryArticleAmountByCategoryId() {
        System.out.println(articleDao.queryArticleAmountByCategoryId(2));
        System.out.println(articleDao.queryArticleAmountByCategoryId(4));
    }

    @Test
    public void updateArticle() {
        Article article = articleDao.queryArticleById(2);
        article.setArticleTitle("title22");
        article.setArticleContentHTML("html22");
        article.setArticleContentMD("md22");
        article.setArticleStatus(1);
        article.setArticleDate(new Date());
        System.out.println(articleDao.updateArticle(article));
    }

    @Test
    public void insertArticle() {
        Article article = new Article();
        article.setArticleTitle("title4");
        article.setArticleContentHTML("html4");
        article.setArticleContentMD("md4");
        article.setArticleStatus(1);
        article.setArticleCategoryId(15);
        article.setArticleDate(new Date());
        System.out.println(articleDao.insertArticle(article));
    }

    @Test
    public void deleteArticleById() {
        System.out.println(articleDao.deleteArticleById(5));
    }
}