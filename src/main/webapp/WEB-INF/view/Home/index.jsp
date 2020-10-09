<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>

<rapid:override name="siteContent">
  <!-- 首部页面 -->
  <header class="masthead" style="background-image: url('/uploads/bg.jpg')">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <div class="site-heading">
            <h1>Kajune's Blog</h1>
            <span class="subheading">&lt;!-- 分享技术，分享错误，分享成长 --&gt;</span>
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
        <!-- 文章块 -->
        <div class="post-preview">
          <a href="/article/post">
            <h2 class="post-title">
              #标题
            </h2>
            <h3 class="post-subtitle">
              #副标题（摘要）
            </h3>
          </a>
          <p class="post-meta">作者：
            <a href="#">#作者</a>
            # 时间</p>
        </div>
        <!-- 文章块结束 -->
        <hr>
        <div class="post-preview">
          <a href="Article/post.jsp">
            <h2 class="post-title">
              #标题
            </h2>
            <h3 class="post-subtitle">
              #副标题（摘要）
            </h3>
          </a>
          <p class="post-meta">作者：
            <a href="#">#作者</a>
            # 时间</p>
        </div>
        <hr>
        <div class="post-preview">
          <a href="Article/post.jsp">
            <h2 class="post-title">
              #标题
            </h2>
            <h3 class="post-subtitle">
              #副标题（摘要）
            </h3>
          </a>
          <p class="post-meta">作者：
            <a href="#">#作者</a>
            # 时间</p>
        </div>
        <hr>
        <div class="post-preview">
          <a href="Article/post.jsp">
            <h2 class="post-title">
              #标题
            </h2>
            <h3 class="post-subtitle">
              #副标题（摘要）
            </h3>
          </a>
          <p class="post-meta">作者：
            <a href="#">#作者</a>
            # 时间</p>
        </div>
        <hr>
        <!-- 页脚 -->
        <%@ include file="Common/page.jsp"%>
      </div>
    </div>
  </div>
  <!-- 主页面结束 -->
</rapid:override>

<%@include file="Common/blogBody.jsp"%>
