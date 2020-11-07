<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>

<rapid:override name="siteContent">
  <!-- 首部页面 -->
  <header class="masthead" style="background-image: url('/uploads/bg.jpg')">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <div class="page-heading">
            <img src="${sessionBlogConfig.blogPortrait}" class="rounded" style="height: 120px; width: 120px;"/>
            <h1>${sessionBlogConfig.blogName}</h1>
            <span class="subheading">${sessionBlogConfig.blogSubtitle}</span>
          </div>
        </div>
      </div>
    </div>
  </header>
  <!-- 首部页面结束 -->

  <!-- 主页面 -->
  <div class="container">
    <div class="row">
      <div class="col-lg-8 col-md-10 mx-auto">
        <p class="text-center">Email: ${sessionBlogConfig.blogEmail}</p>
        <p class="text-center">Github: <a href="${sessionBlogConfig.blogGithub}">${sessionBlogConfig.blogGithub}</a></p>
        <p class="text-center">${sessionBlogConfig.blogDescript}</p>
      </div>
    </div>
  </div>
  <!-- 主页面结束 -->
</rapid:override>

<%@include file="../Common/blogBody.jsp"%>