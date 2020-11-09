package com.jiajunliang.ssm.simpleblog.service;


import com.jiajunliang.ssm.simpleblog.bean.Article;

import java.util.List;

public interface ArticleService {

    /**
     * Get article info according to article id
     * @param articleId article id
     * @return article object
     */
    Article getArticleById(int articleId);

    /**
     * Get all articles
     * @return list contains all article objects
     */
    List<Article> getAllArticles();

    /**
     * Get all articles that are related to a specific category
     * @param categoryId category id
     * @return list contains all article objects that fulfill requirement
     */
    List<Article> getArticlesByCategoryId(int categoryId);

    /**
     * Count the amount of articles belong to specific category
     * @param categoryId specify category
     * @return amount of articles that fulfill requirement
     */
    int countArticleByCategoryId(int categoryId);

    /**
     * Update article info
     * @param article article object that contains update info
     * @return true if update success, false if update fail
     */
    boolean updateArticle(Article article);

    /**
     * Add article
     * @param article a new article object
     * @return true if add success, false if add fail
     */
    boolean addArticle(Article article);

    /**
     * Delete article
     * @param articleId article id
     * @return true if delete success, false if delete fail
     */
    boolean deleteArticleById(int articleId);

}
