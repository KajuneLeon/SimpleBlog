<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh">
    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="SimpleBlog">
        <meta name="author" content="Kajune">

        <title>${sessionBlogConfig.blogName}'s Blog</title>

        <%-- 引入依赖文件 --%>
        <%@ include file="head.jsp"%>

    </head>

    <body>

        <!-- 导航栏 -->
        <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand" href="/" style="font-size: 20px">${sessionBlogConfig.blogName}'s Blog</a>
                <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="/" style="font-size: 20px">首页</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/about" style="font-size: 20px">关于我</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="font-size: 20px">
                                文章列表
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <%--<li>
                                    <div class="dropdown-submenu">
                                        <a class="dropdown-item" tabindex="-1" href="#">JavaEE</a>
                                        <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
                                            <a class="dropdown-item" href="#">集合</a>
                                            <a class="dropdown-item" href="#">多线程</a>
                                        </div>
                                    </div>
                                </li>
                                <li class="dropdown-divider"></li>
                                <li>
                                    <a class="dropdown-item" href="#">Java2EE</a>
                                </li>
                                <li class="dropdown-divider"></li>
                                <li>
                                    <a class="dropdown-item" href="#">Spring</a>
                                </li>--%>
                                <c:forEach items="${sessionCategories}" var="category">
                                    <c:if test="${category.categoryPId == 0}">
                                        <li>
                                            <div class="dropdown-submenu">
                                                <a class="dropdown-item" tabindex="-1" href="#">${category.categoryName}</a>
                                                <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
                                                    <c:forEach items="${sessionCategories}" var="subCategory">
                                                        <c:if test="${subCategory.categoryPId == category.categoryId}">
                                                            <a class="dropdown-item" href="#">${subCategory.categoryName}</a>
                                                        </c:if>
                                                    </c:forEach>
                                                </div>
                                            </div>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${sessionBlogConfig.blogGithub}" target="view_window" style="font-size: 20px">Github</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/" style="font-size: 20px">进入后台</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- 导航栏结束 -->

        <!-- 网站内容，需完成首部页面+主页面 -->
        <rapid:block name="siteContent">

        </rapid:block>

        <hr>

        <!-- 页脚 -->
        <footer>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-md-10 mx-auto">
                        <ul class="list-inline text-center">
                            <li class="list-inline-item">
                                <a href="http://wpa.qq.com/msgrd?V=3&amp;uin=${sessionBlogConfig.blogQQ}&amp;Site=QQ&amp;Menu=yes" target="view_window">
                <span class="fa-stack fa-lg">
                  <i class="fas fa-circle fa-stack-2x"></i>
                  <i class="fab fa-qq fa-stack-1x fa-inverse"></i>
                </span>
                                </a>
                            </li>
                            <li class="list-inline-item">
                                <a href="${sessionBlogConfig.blogGithub}">
                <span class="fa-stack fa-lg">
                  <i class="fas fa-circle fa-stack-2x"></i>
                  <i class="fab fa-github fa-stack-1x fa-inverse"></i>
                </span>
                                </a>
                            </li>
                        </ul>
                        <p class="copyright text-muted">Copyright &copy; ${sessionBlogConfig.blogName} 2020</p>
                    </div>
                </div>
            </div>
        </footer>

    </body>

</html>
