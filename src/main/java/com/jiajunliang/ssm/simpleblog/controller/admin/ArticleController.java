package com.jiajunliang.ssm.simpleblog.controller.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiajunliang.ssm.simpleblog.bean.Article;
import com.jiajunliang.ssm.simpleblog.bean.Category;
import com.jiajunliang.ssm.simpleblog.service.ArticleService;
import com.jiajunliang.ssm.simpleblog.service.CategoryService;
import com.jiajunliang.ssm.simpleblog.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @project: SimpleBlog
 * @program: ArticleController
 * @description: ArticleController
 * @author: JIAJUN LIANG
 * @create: 2020-11-08 09:23
 **/
@Controller
public class ArticleController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ArticleService articleService;

    @RequestMapping(value = {"/admin/article/edit"})
    public String articleEdit(Model model) {
        List<Category> categories = categoryService.getAllCategory();
        model.addAttribute("categories", categories);
        return "Admin/Article/edit";
    }

    @RequestMapping(value = {"/admin/article/list"})
    public String articleList(@RequestParam(value = "pn", defaultValue = "1") int pn, Model model) {
        // 标明当前页面及页面内容数量
        PageHelper.startPage(pn, 6);

        List<Article> articles = articleService.getAllArticles();
        List<Category> categories = categoryService.getAllCategory();

        // 封装分页信息
        PageInfo<Article> articlePageInfo = new PageInfo<>(articles, 5);

        // 分页模型
        model.addAttribute("pageInfo", articlePageInfo);
        model.addAttribute("url", "/admin/article/list?pn=");
        model.addAttribute("categories", categories);

        return "Admin/Article/list";
    }

    @RequestMapping(value = {"/admin/article/modify/{articleId}"})
    public String articleModify(@PathVariable("articleId") int articleId, Model model) {

        Article article = articleService.getArticleById(articleId);
        model.addAttribute("article", article);

        return "forward:/admin/article/edit";
    }

    @RequestMapping(value = {"/admin/article/submitArticle"}, method = RequestMethod.PUT)
    public String articleUpdate(Article article,
                                @RequestParam(value = "blog-editormd-markdown-doc", required = true) String markdown,
                                @RequestParam(value = "blog-editormd-html-code", required = true) String html) {

        article.setArticleContentMD(markdown);
        article.setArticleContentHTML(html);
        article.setArticleDate(new Date());

        articleService.updateArticle(article);

        return "redirect:/admin/article/list";
    }

    @RequestMapping(value = {"/admin/article/submitArticle"}, method = RequestMethod.POST)
    public String articleAdd(Article article,
                             @RequestParam(value = "blog-editormd-markdown-doc", required = true) String markdown,
                             @RequestParam(value = "blog-editormd-html-code", required = true) String html) {

        article.setArticleContentMD(markdown);
        article.setArticleContentHTML(html);
        article.setArticleDate(new Date());

        articleService.addArticle(article);

        return "redirect:/admin/article/list?pn="+Integer.MAX_VALUE;
    }


    @RequestMapping(value = {"/admin/article/delete/{articleId}/{pn}"})
    public String articleDelete(@PathVariable("articleId") int articleId,
                                @PathVariable("pn") int pn) {
        articleService.deleteArticleById(articleId);
        return "redirect:/admin/article/list?pn="+pn;
    }

    /**
     * For image uploading in md
     * @param file image file uploaded in markdown editor
     * @return json
     * @throws IOException IO error happens
     */
    @RequestMapping(value = {"/admin/article/imageUpload"})
    @ResponseBody
    public String imageUpload(@RequestParam(value = "editormd-image-file", required = true) MultipartFile file) throws IOException {

        String originalFileName = file.getOriginalFilename();
        String suffix = originalFileName.substring(originalFileName.lastIndexOf("."));
        String fileName = System.currentTimeMillis() + CommonUtils.getRandomNum(1000) + suffix;

        file.transferTo(new File("D:\\JavaProject\\SimpleBlog-uploads\\article\\" + fileName));
        String fileURL = "/uploads/article/" + fileName;

        Map<String, Object> map = new HashMap<>();
        map.put("success", 1);
        map.put("message", "upload success");
        map.put("url", fileURL);

        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.writeValueAsString(map);
    }
}
