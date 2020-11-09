package com.jiajunliang.ssm.simpleblog.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @project: SimpleBlog
 * @program: Article
 * @description: Article
 * @author: JIAJUN LIANG
 * @create: 2020-11-08 11:26
 **/
public class Article implements Serializable {

    private static final long serialVersionUID = 5298324934572066060L;
    private int articleId;
    private String articleTitle;
    private String articleContentHTML;
    private String articleContentMD;
    private int articleStatus;
    private int articleCategoryId;
    private Date articleDate;

    public Article() {
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleContentHTML='" + articleContentHTML + '\'' +
                ", articleContentMD='" + articleContentMD + '\'' +
                ", articleStatus=" + articleStatus +
                ", articleCategoryId=" + articleCategoryId +
                ", articleDate=" + articleDate +
                '}';
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContentHTML() {
        return articleContentHTML;
    }

    public void setArticleContentHTML(String articleContentHTML) {
        this.articleContentHTML = articleContentHTML;
    }

    public String getArticleContentMD() {
        return articleContentMD;
    }

    public void setArticleContentMD(String articleContentMD) {
        this.articleContentMD = articleContentMD;
    }

    public int getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(int articleStatus) {
        this.articleStatus = articleStatus;
    }

    public int getArticleCategoryId() {
        return articleCategoryId;
    }

    public void setArticleCategoryId(int articleCategoryId) {
        this.articleCategoryId = articleCategoryId;
    }

    public Date getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(Date articleDate) {
        this.articleDate = articleDate;
    }
}
