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
            <img src="/uploads/github.jpg" class="rounded" style="height: 120px; width: 120px;"/>
            <h1>Kajune</h1>
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
        <p class="text-center">Email: xxxxxxx@xx.com</p>
        <p class="text-center">Github: <a href="https://github.com/KajuneLeon">https://github.com/KajuneLeon</a></p>
        <p class="text-center">#Desprition</p>
      </div>
    </div>
  </div>
  <!-- 主页面结束 -->
</rapid:override>

<%@include file="../Common/blogBody.jsp"%>