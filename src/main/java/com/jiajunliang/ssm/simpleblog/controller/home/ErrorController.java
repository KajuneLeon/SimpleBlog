package com.jiajunliang.ssm.simpleblog.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @project: SimpleBlog
 * @program: ErrorController
 * @description: ErrorController
 * @author: JIAJUN LIANG
 * @create: 2020-11-08 21:10
 **/
@Controller
public class ErrorController {

    @RequestMapping(value = {"/error"})
    public String errorPage() {
        return "Home/Error/404";
    }
}
