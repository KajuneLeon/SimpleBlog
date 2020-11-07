package com.jiajunliang.ssm.simpleblog.service;

import com.jiajunliang.ssm.simpleblog.bean.BlogConfig;

public interface BlogConfigService {

    /**
     * Get latest blog configuration
     * @return A BlogConfig object, contains latest blog configuration
     */
    BlogConfig getLatestBlogConfig();

    /**
     * Save blog configuration
     * @param blogConfig A BlogConfig object, contains modified blog configuration
     * @return true if save success, else false
     */
    boolean saveBlogConfig(BlogConfig blogConfig);

}
