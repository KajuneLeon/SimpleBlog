package com.jiajunliang.ssm.simpleblog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiajunliang.ssm.simpleblog.bean.Category;
import com.jiajunliang.ssm.simpleblog.service.CategoryService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @project: SimpleBlog
 * @program: CategoryController
 * @description: CategoryController
 * @author: JIAJUN LIANG
 * @create: 2020-11-07 17:15
 **/

@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = {"/admin/category"})
    public String categoryPage(@RequestParam(value = "pn", defaultValue = "1") int pageNumber, Model model) {
        // 标明当前页及页面内容数量
        PageHelper.startPage(pageNumber, 6);

        List<Category> categories = categoryService.getAllCategory();

        // 封装页面信息
        PageInfo<Category> categoryPageInfo = new PageInfo<>(categories, 5);

        // 分页模型
        model.addAttribute("pageInfo", categoryPageInfo);
        model.addAttribute("url", "/admin/category?pn=");

        // 一级分类信息
        List<Category> firstCategories = categoryService.getAllFirstCategory();
        model.addAttribute("firstCategories", firstCategories);

        return "Admin/Category/editList";
    }

    @RequestMapping(value = {"/admin/category/edit/{categoryId}/{pn}"})
    public String categoryEdit(@PathVariable("categoryId") int categoryId,
                               @PathVariable("pn") int pn,
                               Model model) {
        Category category = categoryService.getCategoryById(categoryId);

        // 判断一级分类 / 二级分类
        if (category.isFirstCategory()) {
            model.addAttribute("firstCategoryInfo", category);
        } else {
            model.addAttribute("secondCategoryInfo", category);
        }

        return "forward:/admin/category?pn="+pn;
    }

    @RequestMapping(value = {"/admin/category/submitCategory"}, method = RequestMethod.POST)
    public String addCategory(@RequestParam(value = "categoryPId", defaultValue = "0", required = false) int categoryPId,
                              @RequestParam(value = "categoryName", required = true) String categoryName) {

        Category category = new Category();
        category.setCategoryName(categoryName);
        category.setCategoryPId(categoryPId);

        categoryService.addCategory(category);

        return "redirect:/admin/category?pn="+Integer.MAX_VALUE;
    }

    @RequestMapping(value = {"/admin/category/submitCategory"}, method = RequestMethod.PUT)
    public String updateCategory(Category category, int pn) {
        categoryService.updateCategory(category);
        return "redirect:/admin/category?pn="+pn;
    }

    @RequestMapping(value = {"admin/category/delete/{categoryId}/{pn}"})
    public String deleteCategory(@PathVariable("categoryId") int categoryId,
                                 @PathVariable("pn") int pn) {
        categoryService.deleteCategoryById(categoryId);
        return "redirect:/admin/category?pn="+pn;
    }



}
