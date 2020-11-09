package com.jiajunliang.ssm.simpleblog.service;

import com.jiajunliang.ssm.simpleblog.bean.Article;
import com.jiajunliang.ssm.simpleblog.bean.Category;
import com.jiajunliang.ssm.simpleblog.dao.ArticleDao;
import com.jiajunliang.ssm.simpleblog.dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @project: SimpleBlog
 * @program: ArticleServiceImpl
 * @description: ArticleServiceImpl
 * @author: JIAJUN LIANG
 * @create: 2020-11-08 13:26
 **/

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    ArticleDao articleDao;

    @Autowired
    CategoryDao categoryDao;

    @Override
    public Article getArticleById(int articleId) {
        return articleDao.queryArticleById(articleId);
    }

    @Override
    public List<Article> getAllArticles() {
        return articleDao.queryAllArticles();
    }

    @Override
    public List<Article> getArticlesByCategoryId(int categoryId) {
        return articleDao.queryArticlesByCategoryId(categoryId);
    }

    @Override
    public List<Article> getArticlesIssued() {
        return articleDao.queryArticlesByStatus(1);
    }

    @Override
    public List<Article> getIssuedArticlesByCategoryIds(List<Integer> categoryIds) {
        return articleDao.queryIssuedArticleByCategories(categoryIds);
    }

    @Override
    public int countArticleByCategoryId(int categoryId) {
        return articleDao.queryArticleAmountByCategoryId(categoryId);
    }

    @Override
    public boolean updateArticle(Article article) {
        return articleDao.updateArticle(article) != 0;
    }

    @Override
    public boolean addArticle(Article article) {
        return articleDao.insertArticle(article) != 0;
    }

    @Override
    public boolean deleteArticleById(int articleId) {
        return articleDao.deleteArticleById(articleId) != 0;
    }
}
