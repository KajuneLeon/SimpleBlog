package com.jiajunliang.ssm.simpleblog.service;

import com.jiajunliang.ssm.simpleblog.bean.Category;
import com.jiajunliang.ssm.simpleblog.dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
