<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>

<rapid:override name="siteContent">
  <!-- 首部页面 -->
  <header class="masthead" style="background-image: url('/uploads/bg.jpg')">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <div class="post-heading">
            <h1>#文章标题</h1>
            <h2 class="subheading">#一级分类&nbsp;#二级分类</h2>
            <span class="meta">作者：
              <a href="#">#作者名</a>&nbsp;
              #时间</span>
          </div>
        </div>
      </div>
    </div>
  </header>
  <!-- 首部页面结束 -->

  <!-- 主页面 -->
  <article>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          #Article Content
        </div>
      </div>
    </div>
  </article>
  <!-- 主页面结束 -->
</rapid:override>

<%@include file="../Common/blogBody.jsp"%>