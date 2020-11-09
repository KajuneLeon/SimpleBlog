package com.jiajunliang.ssm.simpleblog.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @project: SimpleBlog
 * @program: AboutController
 * @description: AboutController
 * @author: JIAJUN LIANG
 * @create: 2020-11-09 23:09
 **/
@Controller
public class AboutController {

    @RequestMapping(value = {"/about"})
    public String about() {
        return "Home/About/about";
    }

}
