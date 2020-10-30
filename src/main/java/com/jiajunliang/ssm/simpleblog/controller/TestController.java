package com.jiajunliang.ssm.simpleblog.controller;

import com.jiajunliang.ssm.simpleblog.bean.User;
import com.jiajunliang.ssm.simpleblog.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: SimpleBlog
 * @description:
 * @author: Kajune Leung
 * @create: 2020-10-07 10:48
 **/
@Controller
public class TestController {

    @Autowired
    UserDao userDao;

    @RequestMapping(value = {"/"})
    public String index() {
        System.out.println("hi");
        return "Home/index";
    }

    @RequestMapping(value = {"/article/post"})
    public String post() {
        System.out.println("hi");
        return "Home/Article/post";
    }

    @RequestMapping(value = {"/about"})
    public String about() {
        System.out.println("hi");
        return "Home/About/about";
    }

    @RequestMapping(value = {"/admin"})
    public String admin() {
        System.out.println("hi");
        return "Admin/homepage";
    }

    @RequestMapping(value = {"/admin/user"})
    public String user() {
        System.out.println("hi");
        return "Admin/User/edit";
    }

    @RequestMapping(value = {"/admin/article/list"})
    public String articleList() {
        System.out.println("hi");
        return "Admin/Article/list";
    }

    @RequestMapping(value = {"/admin/article/edit"})
    public String articleEdit() {
        System.out.println("hi");
        return "Admin/Article/edit";
    }

    @RequestMapping(value = {"/admin/category"})
    public String category() {
        System.out.println("hi");
        return "Admin/Category/editList";
    }

    @RequestMapping(value = {"/login"})
    public String login() {
        System.out.println("hi");
        return "Admin/User/login";
    }

    @RequestMapping(value = {"/admin/article/submitArticle"})
    public String submitArticle(@RequestParam("blog-editormd-html-code") String blogMd, Model model) {
        System.out.println(blogMd);
        model.addAttribute("blogMd", blogMd);
        model.addAttribute("test", 1);
        return "Home/success";
    }

}
