package com.jiajunliang.ssm.simpleblog.interceptor;

import com.jiajunliang.ssm.simpleblog.bean.BlogConfig;
import com.jiajunliang.ssm.simpleblog.service.BlogConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @project: SimpleBlog
 * @program: ConfigLoaderInterceptor
 * @description: Loading blog configuration
 * @author: JIAJUN LIANG
 * @create: 2020-10-31 21:37
 **/
@Component
public class ConfigLoaderInterceptor implements HandlerInterceptor {

    @Autowired
    BlogConfigService blogConfigService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        BlogConfig blogConfig = blogConfigService.getLatestBlogConfig();
        request.getSession().setAttribute("sessionBlogConfig", blogConfig);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
