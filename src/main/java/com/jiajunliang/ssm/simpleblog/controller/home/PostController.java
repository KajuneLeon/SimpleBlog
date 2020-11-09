package com.jiajunliang.ssm.simpleblog.controller.home;

import com.jiajunliang.ssm.simpleblog.bean.Article;
import com.jiajunliang.ssm.simpleblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @project: SimpleBlog
 * @program: PostController
 * @description: PostController
 * @author: JIAJUN LIANG
 * @create: 2020-11-09 23:10
 **/
@Controller
public class PostController {

    @Autowired
    ArticleService articleService;

    @RequestMapping(value = {"/article/{articleId}"})
    public String article(@PathVariable(value = "articleId") int articleId, Model model) {

        Article article = articleService.getArticleById(articleId);
        model.addAttribute("article", article);

        return "Home/Article/post";
    }

}
