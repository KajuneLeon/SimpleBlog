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
          <div class="post-heading">
            <h1>${article.articleTitle}</h1>
            <h2 class="subheading">
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
            </h2>
            <h3 class="meta">作者：<a href="/about">${sessionBlogConfig.blogName}</a></h3>
            <h3 class="meta">时间：${article.articleDate}</h3>
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
          ${article.articleContentHTML}
        </div>
      </div>
    </div>
  </article>

  <script type="text/javascript">
    // $("img").addClass("carousel-inner img-rounded");
    $("img").addClass("img-fluid img-rounded d-block mx-auto");
  </script>

  <!-- 主页面结束 -->
</rapid:override>

<%@include file="../Common/blogBody.jsp"%>