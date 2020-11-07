package com.jiajunliang.ssm.simpleblog.service;

import com.jiajunliang.ssm.simpleblog.bean.BlogConfig;
import com.jiajunliang.ssm.simpleblog.dao.BlogConfigDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @project: SimpleBlog
 * @program: BlogConfigServiceImpl
 * @description: BlogConfigService implementation
 * @author: JIAJUN LIANG
 * @create: 2020-10-31 19:02
 **/
@Service
@Transactional
public class BlogConfigServiceImpl implements BlogConfigService{

    @Autowired
    private BlogConfigDao blogConfigDao;

    @Override
    public BlogConfig getLatestBlogConfig() {
        return blogConfigDao.queryLatestBlogConfig();
    }

    @Override
    public boolean saveBlogConfig(BlogConfig blogConfig) {
        return blogConfigDao.updateBlogConfig(blogConfig)!=0;
    }
}
