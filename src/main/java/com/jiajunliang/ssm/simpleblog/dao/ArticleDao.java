package com.jiajunliang.ssm.simpleblog.dao;

import com.jiajunliang.ssm.simpleblog.bean.Article;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ArticleDao {

    Article queryArticleById(@Param("articleId") int articleId);

    List<Article> queryAllArticles();

    List<Article> queryArticlesByCategoryId(@Param("categoryId") int categoryId);

    List<Article> queryArticlesByStatus(@Param("articleStatus") int articleStatus);

    List<Article> queryIssuedArticleByCategories(@RequestParam("articleCategoryIds") List<Integer> articleCategoryIds);

    int queryArticleAmountByCategoryId(@Param("categoryId") int categoryId);

    int updateArticle(Article article);

    int insertArticle(Article article);

    int deleteArticleById(@Param("articleId") int articleId);

}
