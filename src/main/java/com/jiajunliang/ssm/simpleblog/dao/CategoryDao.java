package com.jiajunliang.ssm.simpleblog.dao;

import com.jiajunliang.ssm.simpleblog.bean.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryDao {

    Category queryCategoryById(@Param("categoryId") int categoryId);

    List<Category> queryAllCategory();

    List<Category> queryAllFirstCategory();

    int updateCategory(Category category);

    int insertCategory(Category category);

    int deleteCategoryById(@Param("categoryId") int categoryId);

}
