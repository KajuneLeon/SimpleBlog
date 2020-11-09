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
          <%--###########################################################################--%>
          <p><img src="/uploads/article/1604830032751.jpg" alt="hi" title="hi">
            <br>
            这是我上传的图片
            <br>
            <img src="/uploads/article/1604830158003.jpg" alt="cat" title="cat">
          </p>
          <%--###########################################################################--%>
        </div>
      </div>
    </div>
  </article>

  <script type="text/javascript">
    // $("img").addClass("carousel-inner img-rounded");
    $("img").addClass("img-fluid img-rounded");
  </script>

  <!-- 主页面结束 -->
</rapid:override>

<%@include file="../Common/blogBody.jsp"%>