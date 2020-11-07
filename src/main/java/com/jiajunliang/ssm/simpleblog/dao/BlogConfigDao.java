package com.jiajunliang.ssm.simpleblog.dao;

import com.jiajunliang.ssm.simpleblog.bean.BlogConfig;
import org.apache.ibatis.annotations.Param;

public interface BlogConfigDao {

    BlogConfig queryBlogConfigById(@Param("blogId") int blogId);

    BlogConfig queryLatestBlogConfig();

    int updateBlogConfig(BlogConfig blogConfig);

    int insertBlogConfig(BlogConfig blogConfig);

    int deleteBlogConfigById(@Param("blogId") int blogId);

}
