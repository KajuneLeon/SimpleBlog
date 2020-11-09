package com.jiajunliang.ssm.simpleblog.service;

import com.jiajunliang.ssm.simpleblog.bean.Article;
import com.jiajunliang.ssm.simpleblog.dao.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
