package com.jiajunliang.ssm.simpleblog.service;

import com.jiajunliang.ssm.simpleblog.bean.Category;

import java.util.List;

public interface CategoryService {

    /**
     * Get all first categories
     * @return a list containing all first categories
     */
    List<Category> getAllFirstCategory();

    /**
     * Get all categories
     * @return a list containing all categories
     */
    List<Category> getAllCategory();

    /**
     * Get the first category and second category if the input categoryId is a first category's id
     * else
     * only get this categoryId
     * @param categoryId a category id
     * @return category list
     */
    List<Integer> getFirstAndSecondCategoryIdById(int categoryId);

    /**
     * Get a specific category by categoryId
     * @param categoryId an integer number
     * @return a category encapsulates id, pid and name
     */
    Category getCategoryById(int categoryId);

    /**
     * Update category info according to the input
     * @param category a category object contains all update info
     * @return true if update success, false if update fail
     */
    boolean updateCategory(Category category);

    /**
     * Add category according to the input
     * @param category a category object contains all category info
     * @return true if add success, false if add fail
     */
    boolean addCategory(Category category);

    /**
     * Delete category according to the id, if this category is the first category,
     * then second categories that are related to this first category also will be deleted
     * @param categoryId an integer number
     * @return true if delete success, false if delete fail
     */
    boolean deleteCategoryById(int categoryId);



}
