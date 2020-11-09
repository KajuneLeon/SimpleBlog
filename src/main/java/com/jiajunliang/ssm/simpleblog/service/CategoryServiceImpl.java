package com.jiajunliang.ssm.simpleblog.service;

import com.jiajunliang.ssm.simpleblog.bean.Category;
import com.jiajunliang.ssm.simpleblog.dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

/**
 * @project: SimpleBlog
 * @program: CategoryServiceImpl
 * @description: CategoryService implementation
 * @author: JIAJUN LIANG
 * @create: 2020-11-07 16:52
 **/
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDao categoryDao;

    @Override
    public List<Category> getAllFirstCategory() {
        return categoryDao.queryAllFirstCategory();
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryDao.queryAllCategory();
    }

    @Override
    public List<Integer> getFirstAndSecondCategoryIdById(int categoryId) {
        // 获取当前类信息
        Category category = categoryDao.queryCategoryById(categoryId);

        List<Category> subCategories = null;

        // 若是categoryPId==0则为一级分类，寻找其下所有二级分类
        if(category.getCategoryPId()==0) {
            subCategories = categoryDao.queryAllCategoryByPId(category.getCategoryId());
        }

        // 保存所有categoryId
        List<Integer> categoriesId = new LinkedList<>();
        categoriesId.add(category.getCategoryId());
        if(subCategories != null) {
            for(Category subcategory: subCategories) {
                categoriesId.add(subcategory.getCategoryId());
            }
        }
        return categoriesId;
    }

    @Override
    public Category getCategoryById(int categoryId) {
        return categoryDao.queryCategoryById(categoryId);
    }

    @Override
    public boolean updateCategory(Category category) {
        return categoryDao.updateCategory(category) != 0;
    }

    @Override
    public boolean addCategory(Category category) {
        return categoryDao.insertCategory(category) != 0;
    }

    @Override
    public boolean deleteCategoryById(int categoryId) {
        return categoryDao.deleteCategoryById(categoryId) != 0;
    }
}
