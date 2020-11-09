package com.jiajunliang.ssm.simpleblog.controller.home;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiajunliang.ssm.simpleblog.bean.Article;
import com.jiajunliang.ssm.simpleblog.bean.Category;
import com.jiajunliang.ssm.simpleblog.service.ArticleService;
import com.jiajunliang.ssm.simpleblog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Iterator;
import java.util.List;

/**
 * @project: SimpleBlog
 * @program: IndexController
 * @description: IndexController
 * @author: JIAJUN LIANG
 * @create: 2020-11-09 16:01
 **/
@Controller
public class IndexController {

    @Autowired
    ArticleService articleService;

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = {"/", "/articleList"})
    public String index(@RequestParam(value = "pn", defaultValue = "1") int pn,
                        Model model) {
        PageHelper.startPage(pn, 6);

        List<Article> articles = articleService.getArticlesIssued();

        PageInfo<Article> articlePageInfo = new PageInfo<>(articles, 5);

        model.addAttribute("pageInfo", articlePageInfo);
        model.addAttribute("url", "/articleList?pn=");

        return "Home/index";
    }

    @RequestMapping(value = {"/articleCategoryList"})
    public String articleCategoryList(@RequestParam(value = "pn", defaultValue = "1") int pn,
                                      @RequestParam(value = "categoryId", required = true) int categoryId,
                                      Model model) {

        // 获取当前分类所有从属id
        List<Integer> categoryIds = categoryService.getFirstAndSecondCategoryIdById(categoryId);

        PageHelper.startPage(pn, 1);
        List<Article> articles = articleService.getIssuedArticlesByCategoryIds(categoryIds);

        PageInfo<Article> articlePageInfo = new PageInfo<>(articles, 5);

        model.addAttribute("pageInfo", articlePageInfo);
        model.addAttribute("url", "/articleCategoryList?categoryId=" + categoryId + "&pn=");

        return "Home/index";
    }

}
