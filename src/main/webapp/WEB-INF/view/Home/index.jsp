<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<rapid:override name="siteContent">
  <!-- 首部页面 -->
  <header class="masthead" style="background-image: url('/uploads/bg.jpg')">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <div class="site-heading">
            <h1>${sessionBlogConfig.blogName}'s Blog</h1>
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

        <!-- 文章块 -->
        <c:forEach items="${pageInfo.list}" var="article">
          <div class="post-preview">
            <a href="/article/${article.articleId}">
              <h2 class="post-title">
                ${article.articleTitle}
              </h2>
              <h4 class="post-subtitle">
                <c:forEach items="${sessionCategories}" var="category">
                  <c:if test="${article.articleCategoryId==category.categoryId}">
                    <c:if test="${category.categoryPId!=0}">
                      <c:forEach items="${sessionCategories}" var="pCategory">
                        <c:if test="${category.categoryPId==pCategory.categoryId}">
                          #${pCategory.categoryName}&nbsp;&nbsp;&nbsp;&nbsp;
                        </c:if>
                      </c:forEach>
                    </c:if>
                    #${category.categoryName}
                  </c:if>
                </c:forEach>
              </h4>
            </a>
            <p class="post-meta">时间：${article.articleDate}</p>
          </div>
          <hr>
        </c:forEach>
        <!-- 文章块结束 -->

        <!-- 页脚 -->
        <%@ include file="Common/page.jsp"%>
      </div>
    </div>
  </div>
  <!-- 主页面结束 -->
</rapid:override>

<%@include file="Common/blogBody.jsp"%>
