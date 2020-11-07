package com.jiajunliang.ssm.simpleblog.controller.admin;

import com.jiajunliang.ssm.simpleblog.bean.BlogConfig;
import com.jiajunliang.ssm.simpleblog.service.BlogConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @project: SimpleBlog
 * @program: BlogController
 * @description: BlogController
 * @author: JIAJUN LIANG
 * @create: 2020-10-31 20:29
 **/
@Controller
public class BlogController {

    @Autowired
    BlogConfigService blogConfigService;

    @RequestMapping(value = {"/admin"})
    public String admin(Model model) {
        return "Admin/homepage";
    }

    @RequestMapping(value = {"/admin/blog/edit"})
    public String blogEditPage(Model model) {
        BlogConfig blogConfig = blogConfigService.getLatestBlogConfig();
        model.addAttribute("blogConfig", blogConfig);
        return "Admin/Blog/edit";
    }

    @RequestMapping(value = {"/admin/blog/update"}, method = RequestMethod.PUT)
    public String blogConfigUpdate(BlogConfig blogConfig, Model model) {
        if (blogConfigService.saveBlogConfig(blogConfig)) {
            model.addAttribute("msg", "保存成功!");
        } else {
            model.addAttribute("msg", "保存失败，请稍后再试！");
        }
        return "forward:/admin/blog/edit";
    }

    @RequestMapping(value = {"/admin/blog/updatePortrait"})
    public String blogPortraitUpdate(MultipartFile portrait, Model model) throws IOException {
        BlogConfig blogConfig = blogConfigService.getLatestBlogConfig();
        String fileName = "blogPortrait-" + portrait.getOriginalFilename();
        portrait.transferTo(new File("D:\\JavaProject\\SimpleBlog-uploads\\" + fileName));
        blogConfig.setBlogPortrait("/uploads/"+fileName);
        if (blogConfigService.saveBlogConfig(blogConfig)) {
            model.addAttribute("msg", "保存成功!");
        } else {
            model.addAttribute("msg", "保存失败，请稍后再试！");
        }
        return "forward:/admin/blog/edit";
    }
}
