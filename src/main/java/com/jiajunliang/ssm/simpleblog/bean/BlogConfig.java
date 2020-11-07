package com.jiajunliang.ssm.simpleblog.bean;

import java.io.Serializable;

/**
 * @project: SimpleBlog
 * @program: BlogConfig
 * @description: Blog configuration class. Contains information of the blog
 * @author: JIAJUN LIANG
 * @create: 2020-10-31 16:47
 **/
public class BlogConfig implements Serializable {

    private int blogId;
    private String blogName;
    private String blogSubtitle;
    private String blogEmail;
    private String blogGithub;
    private String blogQQ;
    private String blogDescript;
    private String blogPortrait;

    public BlogConfig() {
    }

    @Override
    public String toString() {
        return "BlogConfig{" +
                "blogId=" + blogId +
                ", blogName='" + blogName + '\'' +
                ", blogSubtitle='" + blogSubtitle + '\'' +
                ", blogEmail='" + blogEmail + '\'' +
                ", blogGithub='" + blogGithub + '\'' +
                ", blogQQ='" + blogQQ + '\'' +
                ", blogDescript='" + blogDescript + '\'' +
                ", blogPortrait='" + blogPortrait + '\'' +
                '}';
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getBlogSubtitle() {
        return blogSubtitle;
    }

    public void setBlogSubtitle(String blogSubtitle) {
        this.blogSubtitle = blogSubtitle;
    }

    public String getBlogEmail() {
        return blogEmail;
    }

    public void setBlogEmail(String blogEmail) {
        this.blogEmail = blogEmail;
    }

    public String getBlogGithub() {
        return blogGithub;
    }

    public void setBlogGithub(String blogGithub) {
        this.blogGithub = blogGithub;
    }

    public String getBlogQQ() {
        return blogQQ;
    }

    public void setBlogQQ(String blogQQ) {
        this.blogQQ = blogQQ;
    }

    public String getBlogDescript() {
        return blogDescript;
    }

    public void setBlogDescript(String blogDescript) {
        this.blogDescript = blogDescript;
    }

    public String getBlogPortrait() {
        return blogPortrait;
    }

    public void setBlogPortrait(String blogPortrait) {
        this.blogPortrait = blogPortrait;
    }
}
