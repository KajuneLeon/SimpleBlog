package com.jiajunliang.ssm.simpleblog.bean;

import java.io.Serializable;

/**
 * @project: SimpleBlog
 * @program: Category
 * @description: Category, contains the  first category and the second category
 * @author: JIAJUN LIANG
 * @create: 2020-11-07 14:50
 **/
public class Category implements Serializable {

    private int categoryId;
    private int categoryPId;
    private String categoryName;

    public Category() {
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryPId=" + categoryPId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getCategoryPId() {
        return categoryPId;
    }

    public void setCategoryPId(int categoryPId) {
        this.categoryPId = categoryPId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public boolean isFirstCategory() {
        return categoryPId == 0;
    }
}
